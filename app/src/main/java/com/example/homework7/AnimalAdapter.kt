package com.example.homework7

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework7.databinding.ItemAnimalBinding

class AnimalAdapter: RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {
    private var animalList = ArrayList<String>()
    var onLongClick: ((Int) -> Unit)? = null

    inner class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemAnimalBinding.bind(itemView)
        fun bind(animal: String) {
        binding.textName.text = animal
            itemView.setOnLongClickListener{
                onLongClick?.invoke(adapterPosition)
                return@setOnLongClickListener true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false))

    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
       holder.bind(animalList[position])
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(str:String) {
        animalList.add(str)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteItem(position: Int) {
        animalList.removeAt(position)
        notifyDataSetChanged()
    }
}