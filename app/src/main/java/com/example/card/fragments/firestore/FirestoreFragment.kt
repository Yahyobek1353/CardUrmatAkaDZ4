package com.example.card.fragments.firestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.example.card.R
import com.example.card.databinding.FragmentFirestoreBinding


class FirestoreFragment : Fragment() {
    private  val binding: FragmentFirestoreBinding by lazy {
        FragmentFirestoreBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myWebView: WebView = binding.wbMain
        myWebView.loadUrl("https://console.firebase.google.com/project/card-ce8bd/authentication/users")
    }


}