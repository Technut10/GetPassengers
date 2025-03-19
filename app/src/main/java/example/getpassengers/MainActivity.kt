/**
 *  Get Passengers - An app to populate a list of passengers in one screen and return it to another.
 * @author Anthony Putman 3/18/25
 * @version 1.0.0
 */
package example.getpassengers

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {
    val listText:TextView
        get()= findViewById(R.id.show_list)

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    {
            activityResult ->
        val data = activityResult.data
        val count = ((data?.getStringExtra("COUNT") ?: "")).toInt()
        val fName =data?.getStringExtra("first_name") ?: ""
        val lName = data?.getStringExtra("last_name") ?: ""
        val phoneNumber = data?.getStringExtra("phone_number") ?: ""

        for(i in 1..count){

          val passenger =  data?.getStringExtra(("PASS"+i) ?:"")
          listText.append("$passenger")

        }

            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun getList(v: View){
        startForResult.launch(Intent(this, GetPassengers::class.java))
        listText.setText(R.string.returned_list)
    }

}
