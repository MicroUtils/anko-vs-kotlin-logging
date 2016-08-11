package mu.ankovskotlinlogging

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import mu.KLogging

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v(TAG, "This is logging of - android.util.Log logging");
        logger.info { "This is logging of - kotlin-logging" }
    }

    companion object: KLogging()
    private val TAG = "MainActivity"
}
