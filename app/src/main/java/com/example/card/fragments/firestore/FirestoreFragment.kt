package com.example.card.fragments.firestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.card.R


/**
 * A simple [Fragment] subclass.
 * Use the [FirestoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirestoreFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_firestore, container, false)
    }


}