package example.getpassengers

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun getList(v: View){

    }


    // debug logs

    override fun onStart(){
        super.onStart()
        Log.d(ChecksTag, "onStart has been called.")
    }

    override fun onStop() {
        super.onStop()
        Log.d(ChecksTag, "onStop has been called.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ChecksTag, "onPause has been called.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(ChecksTag, "onResume has been called!")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(ChecksTag, "onSaveInstanceState has been called.")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(ChecksTag, "onRestoreInstanceState has been called.")
    }

    companion object{
        private const val ChecksTag = "Ours"
    }

}