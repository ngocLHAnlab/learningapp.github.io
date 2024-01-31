package com.example.learningapp.recyclerview.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.learningapp.R
import com.example.learningapp.databinding.ActivityRecyclerViewBinding
import com.example.learningapp.recyclerview.model.PersonAdapter
import com.example.learningapp.recyclerview.model.PersonInterface
import com.example.learningapp.recyclerview.model.PersonObject
import com.example.learningapp.recyclerview.viewModel.PersonViewModel

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var adapter: PersonAdapter
    lateinit var viewModel: PersonViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_recycler_view)
        viewModel = PersonViewModel(baseContext)
        binding.viewModel = viewModel
        viewModel.personObjects.observe(this) {
            adapter = PersonAdapter(this, it, object : PersonInterface {
                override fun click(personObject: PersonObject) {
                    val intent = Intent(baseContext, DetailActivity::class.java)
                    intent.putExtra("person", personObject)
                    startActivity(intent)
                }
            })
            binding.recy.adapter = adapter
        }
        viewModel.isMan.observe(this) {
            if (it) {
                binding.spinner.setImageResource(R.drawable.ic_baseline_person_24)
            } else {
                binding.spinner.setImageResource(R.drawable.ic_baseline_person_women)
            }
        }
        viewModel.searchText.observe(this) {
            if (it.equals("")){
                viewModel.personObjects.value = viewModel.personObjectsData
            }else{
                val list = ArrayList<PersonObject>()
                for (item in viewModel.personObjectsData){
                    if (item.name.lowercase().contains(it)){
                        list.add(item)
                    }
                }
                viewModel.personObjects.value = list
            }
        }
        val layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)
        binding.recy.layoutManager = layoutManager
    }
}