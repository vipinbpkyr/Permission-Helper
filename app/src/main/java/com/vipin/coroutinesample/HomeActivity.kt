package com.vipin.coroutinesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("HomeActivity","onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onStart() {
        Log.e("HomeActivity","onStart")
        super.onStart()
    }

    override fun onStop() {
        Log.e("HomeActivity","onStop")
        super.onStop()
    }

    override fun onResume() {
        Log.e("HomeActivity","onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.e("HomeActivity","onPause")
        super.onPause()
    }

    override fun onRestart() {
        Log.e("HomeActivity","onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.e("HomeActivity","onDestroy")
        super.onDestroy()
    }
}
