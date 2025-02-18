package com.example.charo_android.presentation.ui.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.charo_android.data.api.ApiService
import com.example.charo_android.data.model.request.signin.RequestSignInData
import com.example.charo_android.data.model.response.signin.ResponseSignInData
import com.example.charo_android.databinding.ActivitySignInBinding
import com.example.charo_android.presentation.ui.main.MainActivity
import com.example.charo_android.presentation.ui.signin.viewmodel.EmailSignInViewModel
import com.example.charo_android.presentation.ui.signup.SignUpActivity
import com.example.charo_android.presentation.util.SharedInformation
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private val emailSignInViewModel : EmailSignInViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickSingUp()
        login()
        binding.imgSigninIdClear.setOnClickListener() { clearEmail() }
        binding.imgSigninPwClear.setOnClickListener() { clearPassword() }
    }

    private fun login() {
        binding.btnSigninLogin.setOnClickListener {
            if (binding.etSigninId.text.isBlank() || binding.etSigninPw.text.isBlank()) {
                Toast.makeText(this, "ID/PW를 입력해주세요!", Toast.LENGTH_LONG).show()
            } else {
                val id = "0"
                SharedInformation.saveSocialId(this, id)
                SharedInformation.setEmail(this, binding.etSigninId.text.toString())
                val requestSignInData = RequestSignInData(
                    userEmail = binding.etSigninId.text.toString(),
                    password = binding.etSigninPw.text.toString()
                )
                emailSignInViewModel.getEmailSignInData(requestSignInData)
                emailSignInViewModel.emailSignInData.observe(this, Observer {
                    Log.d("emailSignIn", it.profileImage.toString())
                })
            }
        }
    }

    private fun clearEmail() {
        binding.etSigninId.text.clear()
    }

    private fun clearPassword() {
        binding.etSigninPw.text.clear()
    }

    private fun clickSingUp(){
        binding.tvSigninSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}