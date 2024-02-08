package com.example.card.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.card.App
import com.example.card.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private val binding: FragmentProfileBinding by lazy {
        FragmentProfileBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtName = App.prefs.showName()
        binding.txtName.text = txtName
        binding.btnSave.setOnClickListener {
            val name = binding.edName.text.toString()
            App.prefs.saveName(name)
            val saveName = App.prefs.showName()
            binding.txtName.text = saveName
        }
    }
}