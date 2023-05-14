package com.example.lab2_kdpz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2_kdpz.Animal
import com.example.lab2_kdpz.AnimalAdapter
import com.example.lab2_kdpz.R
import com.example.lab2_kdpz.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        val animalList = mutableListOf<Animal>()


        animalList.add(Animal("Джонік", "15", R.drawable.parrot,this.resources.getString(R.string.parrot)))
        animalList.add(Animal("Чубзік", "5", R.drawable.monkey,this.resources.getString(R.string.monkey)))
        animalList.add(Animal("Павук", "1", R.drawable.penguin,this.resources.getString(R.string.penguin)))

        recyclerView.adapter = AnimalAdapter(animalList, this)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}