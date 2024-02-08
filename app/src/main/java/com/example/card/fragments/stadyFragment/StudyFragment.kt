package com.example.card.fragments.stadyFragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.card.R
import com.example.card.data.room.model.CardModel
import com.example.card.data.room.model.CategoryModel
import com.example.card.databinding.FragmentProfileBinding
import com.example.card.databinding.FragmentStudyBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class StudyFragment : BottomSheetDialogFragment() {
    private val binding: FragmentStudyBinding by lazy {
        FragmentStudyBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener{
            findNavController().navigate(R.layout.fragment_category)
        }

    }


}