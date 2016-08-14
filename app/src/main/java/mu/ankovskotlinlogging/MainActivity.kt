package mu.ankovskotlinlogging

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.common.base.Stopwatch
import mu.KLogging
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test("android-logging", {Log.v(TAG, "This is logging of - android.util.Log logging")});
        test("kotlin-logging", {logger.info ("This is logging of - kotlin-logging" )});
        test("kotlin-logging-lazy", {logger.info {"This is logging of - kotlin-logging"}});
        test("AnkoLogger", {info ("This is logging of - AnkoLogger" )});
        test("AnkoLogger-lazy", {info {"This is logging of - AnkoLogger"}});
        ChildForLogging().testLog()
    }

    private fun test(testName: String, func: ()-> Unit): Unit {
        val st = Stopwatch.createStarted()
        for (i in 1..10) {
            func.invoke()
        }
        Log.e(TAG, "test-timing: '$testName' took ${st}")

    }

    companion object: KLogging()
    private val TAG = "MainActivity"
}

open class ParentForLogging: AnkoLogger {
    fun testLog() = {info { "lets see the class name" }}
}
class ChildForLogging: ParentForLogging()
