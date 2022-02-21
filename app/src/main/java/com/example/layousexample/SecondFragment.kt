package com.example.layousexample

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment: Fragment() {


    lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_second, container, false)
        textView = view.findViewById(R.id.textview)
        textView.text = "New text"
        return view
    }


    companion object {
        @JvmStatic
        fun newInstance() = SecondFragment()
    }
}