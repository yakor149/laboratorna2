package com.example.lab2_kdpz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab2_kdpz.FirstFragment

class AnimalAdapter(private val names: List<Animal>, val activity: FirstFragment):
    RecyclerView.Adapter<AnimalAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name: TextView = itemView.findViewById(R.id.name)
        var age: TextView = itemView.findViewById(R.id.age)
        var iView: ImageView = itemView.findViewById(R.id.imageView)
        var button: Button = itemView.findViewById(R.id.button)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.animal_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.name.text = names[position].name
        holder.age.text = names[position].age + " років"

        Glide.with(activity)
            .load(names[position].image)
            .into(holder.iView)

        holder.button.setOnClickListener {
            activity.findNavController().navigate(R.id.action_firstFragment_to_secondFragment, Bundle().apply
            {
                putString("description", names[position].description)
                putString("age", names[position].age)
                putInt("imageID", names[position].image)
            })
        }
    }

    override fun getItemCount(): Int {
        return names.size
    }
}