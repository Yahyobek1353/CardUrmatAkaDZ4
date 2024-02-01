package com.example.card.fragments.category

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.card.App
import com.example.card.R
import com.example.card.data.room.model.CategoryModel
import com.example.card.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment() {


    private lateinit var binding: FragmentCategoryBinding

    private lateinit var adapter: CategoryAdapter

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
    }

}