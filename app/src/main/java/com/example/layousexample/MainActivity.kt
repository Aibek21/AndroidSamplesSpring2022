package com.example.layousexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.layousexample.api.ApiService
import com.example.layousexample.dao.UserDao
import com.example.layousexample.databinding.ActivityMainBinding
import com.example.layousexample.model.Todo
import com.example.layousexample.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var counter = 0
    var currentNum = 0
    var previousNum = 0
    var currentOp = ""

    lateinit var db: AppDatabase
    lateinit var userDao: UserDao
    lateinit var users: List<User>

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        val sharedPreferences = getSharedPreferences("default_preferences", MODE_PRIVATE)
//        currentNum = sharedPreferences.getInt("currentNum", 0)

//        Log.e("MainActivity", "Current Num: " + currentNum)
//        Toast.makeText(this, "Current Num: " + currentNum, Toast.LENGTH_SHORT).show()

        db = MyApplication.instance.getDatabase()!!
        userDao = db.userDao()

        users = userDao.getAll()
        for (user in users) {
            Log.e("User", user.uid.toString() + " " + user.firstName + " " + user.lastName)
        }

        binding.button0.setOnClickListener(this)
        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)
        binding.button6.setOnClickListener(this)
        binding.button7.setOnClickListener(this)
        binding.button8.setOnClickListener(this)
        binding.button9.setOnClickListener(this)
        binding.buttonBack.setOnClickListener(this)
        binding.buttonPlus.setOnClickListener(this)
        binding.buttonEquals.setOnClickListener(this)

    }


    override fun onClick(v: View) {
        if (v.id == R.id.button_plus) {
            val user = User(firstName = "Aibek", lastName = "Kuralbayev")
            userDao.insert(user)
            return
        }
        if (v.id in listOf(
                R.id.button_0,
                R.id.button_1,
                R.id.button_2,
                R.id.button_3,
                R.id.button_4,
                R.id.button_5,
                R.id.button_6,
                R.id.button_7,
                R.id.button_8,
                R.id.button_9
            )
        ) {
            binding.topText.text = binding.topText.text.toString().plus((v as Button).text)
            currentNum = Integer.parseInt(binding.topText.text.toString())
        } else if (v.id == R.id.button_back) {
            binding.topText.text = ""
            binding.bottomText.text = ""
            currentNum = 0
            previousNum = 0
        } else if (v.id in listOf(
                R.id.button_plus,
                R.id.button_minus,
                R.id.button_multiply,
                R.id.button_divide
            )
        ) {
            currentOp = (v as Button).text.toString()
            previousNum = binding.topText.text.toString().toInt()
            binding.topText.text = ""
        } else if (v.id == R.id.button_equals) {
            calculate()
        }
    }

    fun calculate() {
        if (currentOp == "+") {
            previousNum = previousNum + binding.topText.text.toString().toInt()
            binding.bottomText.text = previousNum.toString()
        }
    }

    override fun onStop() {
        val sharedPreferences = getSharedPreferences("default_preferences", MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putInt("currentNum", currentNum)
            apply()
        }
        super.onStop()
    }

    override fun onDestroy() {
//        val editor = sharedPreferences.edit()
//        editor.putInt("currentNum", currentNum)
//        editor.apply()
//        currentNum = sharedPreferences.getInt("currentNum", -1)
//        Log.e("MainActivity", "Current Num On Destroy: " + currentNum)
        Toast.makeText(this, "onDestroy: " + currentNum, Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("MainActivity", "onSaveInstanceState")
        outState.putInt("cnt", counter)
    }

}