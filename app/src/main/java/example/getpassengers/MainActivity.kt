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
        val fName =data?.getStringExtra("first_name") ?: ""
        val lName = data?.getStringExtra("last_name") ?: ""
        val phoneNumber = data?.getStringExtra("phone_number") ?: ""

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
    }


}
