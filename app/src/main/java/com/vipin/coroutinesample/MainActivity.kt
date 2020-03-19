package com.vipin.coroutinesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    lateinit var job : Job
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("MainActivity","onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        job = Job()

        supportFragmentManager.beginTransaction()
            .add(R.id.frame, BlankFragment()).commit()

       /* button.setOnClickListener {
            Log.e("MainActivity","onClick")

            startActivity(Intent(this, HomeActivity::class.java))
        }*/

       /* async { // <- extension on current scope
            test("async 1")
            test("async 2")
            test("async 3")
            Log.e("MainActivity","async Completed")
        }



            lifecycleScope.launch{
                test("launch")
            }
            lifecycleScope.launch(Dispatchers.Main){
                test("launch Main")
            }
            lifecycleScope.launch(Dispatchers.Default){
                test("launch Default")
            }
            lifecycleScope.launch(Dispatchers.IO){
                test("launch IO")
            }

        runBlocking {

           // test("runBlocking 1")
          //  test("runBlocking 2")
          //  test("runBlocking 3")

            Log.e("MainActivity","runBlocking Completed")
        }

        Log.e("MainActivity","Completed")*/
    }

    override fun onStart() {
        Log.e("MainActivity","onStart")
        super.onStart()
    }

    override fun onStop() {
        Log.e("MainActivity","onStop")
        super.onStop()
    }

    override fun onResume() {
        Log.e("MainActivity","onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.e("MainActivity","onPause")
        super.onPause()
    }

    override fun onRestart() {
        Log.e("MainActivity","onRestart")
        super.onRestart()
    }

    suspend fun test(str :String) {

        delay(1000)
         Log.e("MainActivity","From $str Current thread " + Thread.currentThread())
    }

    override val coroutineContext: CoroutineContext
        get() =  Dispatchers.Main + job


    override fun onDestroy() {
        Log.e("MainActivity","onDestroy")
        super.onDestroy()

        job.cancel()

        val data = async(Dispatchers.IO) { // <- extension on current scope
        }

        print("$data")

        var s :CompletableDeferred<String>

       // s.complete("s")
    }

    suspend fun showSomeData() = coroutineScope {



           withContext(Dispatchers.Main) {
             //doSomeWork()
            // val result = data.await()
            // display(result)
           }
         }
}
