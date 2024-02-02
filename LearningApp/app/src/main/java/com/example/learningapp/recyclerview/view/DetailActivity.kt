package com.example.learningapp.recyclerview.view

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.learningapp.R
import com.example.learningapp.databinding.ActivityDetailBinding
import com.example.learningapp.recyclerview.model.PersonObject
import com.example.learningapp.recyclerview.viewModel.PersonViewModel

class DetailActivity : AppCompatActivity() {

    lateinit var binding:ActivityDetailBinding
    lateinit var viewModel: PersonViewModel
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        val person = intent.getParcelableExtra<PersonObject>("person") //getSerializableExtra("person", PersonObject::class.java)
        viewModel = PersonViewModel(baseContext)
        viewModel.personObject = person!!
        binding.viewModel = viewModel
        if (person.isMan){
            binding.imgAvatar.setImageResource(R.drawable.ic_baseline_person_24)
        }else{
            binding.imgAvatar.setImageResource(R.drawable.ic_baseline_person_women)
        }
    }
}