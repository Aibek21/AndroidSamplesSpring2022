package com.example.layousexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout

class SecondActivity : AppCompatActivity() {
    //    lateinit var fragment_container: FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.e("Counter", intent.getIntExtra("counter", 0).toString())
//        fragment_container = findViewById(R.id.fragment_container) as FrameLayout

        var fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, SampleFragment.newInstance())
            .addToBackStack("Fragment1")
        fragmentTransaction.add(R.id.fragment_container2, SampleFragment.newInstance())
            .addToBackStack("Fragment1").commit()

        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, SecondFragment.newInstance())
            .addToBackStack("Fragment2").commit()

//        supportFragmentManager.popBackStackImmediate("Fragment1", 0)
        supportFragmentManager.popBackStack()
    }
}