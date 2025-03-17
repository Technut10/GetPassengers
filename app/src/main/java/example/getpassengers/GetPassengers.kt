package example.getpassengers

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class GetPassengers : AppCompatActivity() {
    var flag = false
    var idCount = 0
    private val textFirst: EditText
        get()=findViewById(R.id.first_name)
    private val textLast: EditText
        get()=findViewById(R.id.last_name)
    private val textPhone: EditText
        get()=findViewById(R.id.phone_number)
    private val textPut: TextView
        get()=findViewById(R.id.accum_list)


    var passList = mutableListOf<Passenger>()



    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    {
            activityResult ->
        val data = activityResult.data
        val fName =data?.getStringExtra("$textFirst") ?: ""
        val lname = data?.getStringExtra("$textLast") ?: ""
        val phoneNumber = data?.getStringExtra("$textPhone") ?: ""
        enterPassenger(fName, lname, phoneNumber)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.get_passengers)
    }

    fun toFirst(v:View)
    {
        startForResult.launch(Intent(this, MainActivity::class.java))
    }

    fun backToMain(v:View){
        var firstName = textFirst.text.toString()
        var lastName = textLast.text.toString()
        var phoneNumber =textPhone.text.toString()
        enterPassenger(firstName, lastName, phoneNumber)
        var text = findViewById<TextView>(R.id.accum_list)
        text.setText( passList.toString())
    }


    fun enterPassenger(fname: String, lname: String, phoneNumber:String){

      Intent().let{
          dataIntent ->
          dataIntent.putExtra("COUNT",passList.size.toString())
          dataIntent.putExtra("first_name", fname)
          dataIntent.putExtra("last_name", lname)
          dataIntent.putExtra("phone_number", phoneNumber)
          setResult(Activity.RESULT_OK, dataIntent)
          passList.add(Passenger(fname, lname, phoneNumber))
          var text = findViewById<TextView>(R.id.accum_list)
          text.setText( passList.toString())
          finish()
      }

    }

}