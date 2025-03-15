package example.getpassengers

import android.os.Bundle
import android.content.Intent
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class GetPassengers : AppCompatActivity() {
    var flag = false
    var idCount = 0
    var passList = MutableList(10){

    }

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    {
            activityResult ->
        val data = activityResult.data
        val fName =data?.getStringExtra("first_name")
        val lName = data?.getStringExtra("last_name") ?: ""
        val phoneNumber = data?.getStringExtra("phone_number") ?: ""
        enterPassenger(Passenger(fName.toString(), lName,  phoneNumber))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.get_passengers)
    }

    fun toFirst(v:View)
    {
        var backIntent = Intent(this, MainActivity::class.java)
        startActivity(backIntent)
    }
    fun enterPassenger(p: Passenger){
        flag=!flag

        flag = !flag
        val textView = TextView(this)
        textView.text = p.toString()
        textView.setId(idCount++)
        if(flag) textView.setBackgroundColor(Color.rgb(255, 255, 100))
        else textView.setBackgroundColor(Color.rgb(100, 255, 100))
        textView.textSize = 14F
        textView.setTextColor(Color.BLUE)
    }
}