package com.example.card.fragments.reg

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
    private val binding: FragmentRegisterBinding by lazy {
        FragmentRegisterBinding.inflate(layoutInflater)
    }
    private lateinit var mAuth:FirebaseAuth
    private lateinit var launcher:ActivityResultLauncher<Intent>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAuth = Firebase.auth
        binding.btnReg.setOnClickListener{
            val email = binding.emailEd.text.toString()
            val password = binding.pwEd.text.toString()
            if (checkAllField()){
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                    if (it.isSuccessful){
                        mAuth.signOut()
                        Toast.makeText(requireContext(),"Aкааунт создан успешно",Toast.LENGTH_SHORT)
                        findNavController().navigate(R.id.homeFragment)
                    }
                    else{
                        Log.e("error:", it.exception.toString())
                        Toast.makeText(requireContext(),"Aкааунт не создан",Toast.LENGTH_SHORT)
                    }


                      }
            }


        }

        launcher= registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try {
                val account = task.getResult(ApiException::class.java)
                if (account!=null){
                    account.idToken?.let { it1 -> firebaceAuthWithGoogle(it1) }
                }
            }catch (e:ApiException){
                Log.e("ololo", e.toString())

            }
        }



        getClient()
        binding.googleBtn.setOnClickListener{
            signInWithGoogle()
        }
    }
    private fun checkAllField():Boolean{
        val email = binding.emailEd.text.toString()
        if (binding.emailEd.text.toString()==""){
            binding.textInputLayoutEmail.error = "This is required field"
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.textInputLayoutEmail.error = "Check email format"
            return false
        }
        if (binding.pwEd.text.toString()== ""){
            binding.textInputLayoutPassword.error = "This is required field"
            binding.textInputLayoutPassword.errorIconDrawable = null

            return false
        }
        if (binding.pwEd.length() <= 6){
            binding.textInputLayoutPassword.error = "Пароль слишком коротокий мин 6 символов"
            binding.textInputLayoutPassword.errorIconDrawable = null

        }
        if (binding.pwEdConfirm.text.toString()== ""){
            binding.textInputLayoutConfirmPassword.error = "This is required field"
            binding.textInputLayoutConfirmPassword.errorIconDrawable = null
            return false
        }
        if (binding.pwEd.text.toString() != binding.pwEdConfirm.text.toString()){
            binding.textInputLayoutPassword.error = "Пароли не совпадают"
            return false
        }


        return true

    }
    private fun firebaceAuthWithGoogle(it1:String){
        val credential = GoogleAuthProvider.getCredential(it1,null)
        mAuth.signInWithCredential(credential).addOnCompleteListener{
            if (it.isSuccessful){
                findNavController().navigate(R.id.homeFragment)
            }
        }



    }

    private fun signInWithGoogle() {
        val signInClient = getClient()
        launcher.launch(signInClient.signInIntent)

    }

    private fun getClient():GoogleSignInClient{
        val gso = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        return GoogleSignIn.getClient(requireActivity(),gso)
    }
}