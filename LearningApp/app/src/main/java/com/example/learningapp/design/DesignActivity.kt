package com.example.learningapp.design

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.learningapp.R
import com.example.learningapp.databinding.ActivityDesignBinding
import java.util.*

class DesignActivity : AppCompatActivity() {
    lateinit var binding : ActivityDesignBinding
    lateinit var viewModel: DesignViewModel
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_design)
        viewModel = DesignViewModel(this)
        binding.viewModel = viewModel
        viewModel.dateString.observe(this, {
            binding.textDate.setText(it)
        })
    }
}