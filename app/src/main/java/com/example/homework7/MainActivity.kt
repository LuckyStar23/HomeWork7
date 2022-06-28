package com.example.homework7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var adapter = AnimalAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        initRecycler()
        initListener()
    }

    private fun initListener() {
        adapter.onLongClick = {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete object?")
            builder.setMessage("You want to delete this object?")
            builder.setPositiveButton("Yes, delete this.") {_, _, ->
                adapter.deleteItem(position = it)
                binding.rcView.adapter = adapter
            }
            builder.setNegativeButton("Cancel") {dialogCancel, _ -> dialogCancel.cancel()}
            builder.show()
        }
    }

    private fun initRecycler() {
        binding.rcView.adapter = adapter
    }

    private fun loadData() {
        adapter.addItem("Dog")
        adapter.addItem("Cat")
        adapter.addItem("Monkey")
        adapter.addItem("Elephant")
        adapter.addItem("Horse")
        adapter.addItem("Rabbit")
        adapter.addItem("Lion")
        adapter.addItem("Wolf")
    }
}