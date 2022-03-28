package com.example.layousexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import coil.load
import com.example.layousexample.api.ApiService
import com.example.layousexample.databinding.ActivityMainBinding
import com.example.layousexample.databinding.ActivityRetrofitBinding
import com.example.layousexample.model.Todo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitActivity : AppCompatActivity() {
    lateinit var apiService: ApiService

    private lateinit var binding: ActivityRetrofitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        apiService = MyApplication.instance.getApiService()!!

//        apiService.getTodos().enqueue(object : Callback<List<Todo>> {
//            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
//                Log.e("Error", t.message.toString())
//            }
//
//            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
//                Log.e("Response size: ", response.body()!!.size.toString() + "")
//            }
//        })


//        apiService.getTodoById(1).enqueue(object : Callback<Todo> {
//            override fun onFailure(call: Call<Todo>, t: Throwable) {
//                Log.e("Error", t.message.toString())
//            }
//
//            override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
//                if (response.body() != null)
//                    Log.e("Response size: ", response.body()!!.name + "")
//            }
//        })


//        apiService.getTodosByUserId(completed = true, userId = 4)
//            .enqueue(object : Callback<List<Todo>> {
//                override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
//                    Log.e("Error", t.message.toString())
//                }
//
//                override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
//                    Log.e("Response size: ", response.body()!!.size.toString() + "")
//                }
//            })


//        apiService.createTodo(userId = 123, title = "Finish lab work 5", completed = false)
//            .enqueue(object : Callback<Todo> {
//                override fun onFailure(call: Call<Todo>, t: Throwable) {
//                    Log.e("Error", t.message.toString())
//                }
//
//                override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
//                    if (response.body() != null)
//                        Log.e("Response size: ", response.body()!!.title + "")
//                }
//            })

//
//        apiService.getTodosWithUrl("https://jsonplaceholder.typicode.com/todos/").enqueue(object : Callback<List<Todo>> {
//            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
//                Log.e("Error", t.message.toString())
//            }
//
//            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
//                Log.e("Response size: ", response.body()!!.size.toString() + "")
//            }
//        })

        binding.imageview.load("https://sferaglass.com/storage/images/ZCyNe6QvEf.jpeg")

    }
}