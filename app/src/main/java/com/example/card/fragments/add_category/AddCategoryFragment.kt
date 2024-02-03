package com.example.card.fragments.add_category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.card.App
import com.example.card.R
import com.example.card.data.room.model.CardModel
import com.example.card.data.room.model.CategoryModel
import com.example.card.databinding.FragmentAddCategoryBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


@Suppress("DEPRECATION")
class AddCategoryFragment : BottomSheetDialogFragment() {

    private val binding: FragmentAddCategoryBinding by lazy {
        FragmentAddCategoryBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            if (arguments != null) {
                val text = arguments?.getString("key").toString()
                if (text.equals("element")){
                    val pos = arguments?.getInt("position")!!
                    val list = arguments?.getSerializable("list") as List<CardModel>
                    binding.btnSave.setOnClickListener{
                        val name  = ArrayList<CategoryModel>()
                        val models = ArrayList<CategoryModel>()
                        models.add(CategoryModel(name = name, image = R.drawable.babochka_1))
                    }
                }
            }
            val name = binding.edNameCategory.text.toString()
            val list = ArrayList<CategoryModel>()

            App.database.getDao().insertCard(
                CardModel(name = name, list = list))
            findNavController().navigateUp()
        }
    }
}