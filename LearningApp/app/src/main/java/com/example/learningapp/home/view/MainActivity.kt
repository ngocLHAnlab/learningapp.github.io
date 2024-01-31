package com.example.learningapp.home.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learningapp.Common.Common
import com.example.learningapp.R
import com.example.learningapp.calculator.CalculatorActivity
import com.example.learningapp.databinding.ActivityMainBinding
import com.example.learningapp.design.DesignActivity
import com.example.learningapp.home.model.ButtonTypeAdapter
import com.example.learningapp.home.model.ButtonTypeInterface
import com.example.learningapp.home.model.TypeButton
import com.example.learningapp.home.viewmodel.MainViewModel
import com.example.learningapp.login.LoginActivity
import com.example.learningapp.recyclerview.view.RecyclerViewActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainViewModel()

        val layoutManager = GridLayoutManager(baseContext, 2, RecyclerView.VERTICAL, false)
        binding.recy.layoutManager = layoutManager

        viewModel.buttonTypeObjects.observe(this) {
            val adapter = ButtonTypeAdapter(baseContext, it, object : ButtonTypeInterface {
                override fun click(typeButton: TypeButton) {
                    when (typeButton){
                        TypeButton.design -> startActivity(Intent(baseContext, DesignActivity::class.java))
                        TypeButton.login -> startActivity(Intent(baseContext, LoginActivity::class.java))
                        TypeButton.recy -> startActivity(Intent(baseContext, RecyclerViewActivity::class.java))
                        TypeButton.calculator -> startActivity(Intent(baseContext, CalculatorActivity::class.java))
                        TypeButton.datePicker -> Log.d(Common.TAG, "datePicker")
                        TypeButton.notification -> Log.d(Common.TAG, "notification")
                        TypeButton.splass -> Log.d(Common.TAG, "splass")
                    }
                }
            })
            binding.recy.adapter = adapter
        }
    }
}