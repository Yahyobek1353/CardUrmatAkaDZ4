package com.example.card.fragments.reg

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.navigation.fragment.findNavController
import com.example.card.R
import com.example.card.databinding.FragmentRegisterBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GithubAuthProvider
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import kotlin.math.log


class RegisterFragment : Fragment() {

    private val binding : FragmentRegisterBinding by lazy {
        FragmentRegisterBinding.inflate(layoutInflater)
    }

    private lateinit var mAuth : FirebaseAuth
    private lateinit var launcher : ActivityResultLauncher<Intent>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = Firebase.auth
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try {
                val account = task.getResult(ApiException::class.java)
                if (account != null){
                    account.idToken?.let{it1 -> firebaseAuthWithGoogle(it1) }
                }
            }catch (e:ApiException){
                Log.e("ololo" ,e.toString())

            }
        }
        getClient()
        binding.button.setOnClickListener{
            singInWithGoogle()
        }
    }

    private fun firebaseAuthWithGoogle(it1: String) {
        val credential = GoogleAuthProvider.getCredential(it1 , null)
        mAuth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful){
                findNavController().navigate(R.id.homeFragment)
            }
        }
    }

    private fun singInWithGoogle() {
        val signInClient = getClient()
        launcher.launch(signInClient.signInIntent)
    }



    private fun getClient(): GoogleSignInClient {
        val gso = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        return GoogleSignIn.getClient(requireActivity() , gso)
    }


}