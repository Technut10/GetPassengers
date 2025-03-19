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



//    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
//    {
//            activityResult ->
//        val data = activityResult.data
//        val fName =data?.getStringExtra("$textFirst") ?: ""
//        val lname = data?.getStringExtra("$textLast") ?: ""
//        val phoneNumber = data?.getStringExtra("$textPhone") ?: ""
//        enterPassenger(textPut)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.get_passengers)
    }


    fun backToMain(v:View){
        var firstName = textFirst.text.toString()
        var lastName = textLast.text.toString()
        var phoneNumber =textPhone.text.toString()

        Intent(this, MainActivity::class.java).let{
            dataIntent ->
            dataIntent.putExtra("COUNT",passList.size.toString())
            for (i in 0 until passList.size) {
                dataIntent.putExtra("PASS${i + 1}", passList[i].toString())
            }
            dataIntent.putExtra("first_name", firstName)
            dataIntent.putExtra("last_name", lastName)
            dataIntent.putExtra("phone_number", phoneNumber)
            setResult(Activity.RESULT_OK, dataIntent)
            //startForResult.launch(Intent(this, MainActivity::class.java))
        }
        finish()

    }


    fun enterPassenger(v:View){

        var firstName = textFirst.text.toString()
        var lastName = textLast.text.toString()
        var phoneNumber =textPhone.text.toString()

        var newPass = Passenger(firstName, lastName, phoneNumber)
        passList.add(newPass)

            textPut.append(newPass.toString())
            //passList.add(Passenger(fname,lname,phoneNumber))

            textFirst.setText("")
            textLast.setText("")
            textPhone.setText("")

    }

}