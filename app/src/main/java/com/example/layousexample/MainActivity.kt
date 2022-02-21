package com.example.layousexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var counter = 0
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("MainActivity", "onCreate")
        textView = findViewById(R.id.textview) as TextView

        if (savedInstanceState != null && !savedInstanceState.isEmpty) {
            Log.e("MainActivity", "savedInstanceState")
            counter = savedInstanceState.getInt("cnt", 0)
            textView.text = counter.toString()
        }
    }


    fun onClick(v: View) {
        Log.e("MainActivity", "onClick")

        counter += 1
        textView.text = counter.toString()

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("counter", counter)
        startActivity(intent)
//        finish()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("MainActivity", "onSaveInstanceState")
        outState.putInt("cnt", counter)
    }

    override fun onStart() {
        super.onStart()
        Log.e("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity", "onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MainActivity", "onDestroy")
    }
}