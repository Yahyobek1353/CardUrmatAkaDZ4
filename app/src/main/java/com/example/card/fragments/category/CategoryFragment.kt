package com.example.card.fragments.category

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.navigation.fragment.findNavController
import com.example.card.App
import com.example.card.R
import com.example.card.data.room.model.CardModel
import com.example.card.data.room.model.CategoryModel
import com.example.card.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment() {


    private lateinit var binding: FragmentCategoryBinding
    private lateinit var adapter: CategoryAdapter
    private var pos = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addCategoryFragment)
        }
        initAdapter()
            //Если аргумент не пустой - начало
        if (arguments != null) {
            val list = arguments?.getSerializable("pos") as List<CardModel>
            pos = arguments?.getInt("pos")!!
            adapter.setList(list[pos].list)

            binding.btnAdd.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("key" ,"element")
                val model = ArrayList(list)
                bundle.putSerializable("list" , model)
                bundle.putInt("position" , pos)
                findNavController().navigate(R.id.addCategoryFragment,bundle)
            }
        }
        //Если аргумент не пустой - конец
    }

    private fun initAdapter() {
        adapter = CategoryAdapter()
        binding.rvMain.adapter = adapter
    }

}