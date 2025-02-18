package com.example.charo_android.presentation.ui.signup

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.example.charo_android.R
import com.example.charo_android.databinding.FragmentSignUpPassWordBinding
import com.example.charo_android.presentation.base.BaseFragment
import com.example.charo_android.presentation.ui.signup.viewmodel.SignUpEmailViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.regex.Pattern

class SignUpPassWordFragment :
    BaseFragment<FragmentSignUpPassWordBinding>(R.layout.fragment_sign_up_pass_word) {

    private val signUpViewModel: SignUpEmailViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPasswordView()
        checkPassword()
    }

    private fun initPasswordView() {
        val emailPattern = "^[a-zA-Z0-9]{5,15}$"

        with(binding) {
            etSignUpPassword.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

                override fun afterTextChanged(s: Editable?) {
                    if (s.toString().length < 5 || s.toString().length > 15) {
                        textInputPaasword.error = "5자 이상 15자 이내로 작성해 주세요."

                    } else if (!Pattern.matches(emailPattern, s.toString())) {
                        textInputPaasword.error = "영문과 숫자만 사용해 주세요."
                        Log.d("password", Pattern.matches(emailPattern, s.toString()).toString())
                    } else {
                        textInputPaasword.error = null
                        textInputPaasword.isErrorEnabled = false

                    }


                }
            })
        }
    }


    private fun checkPassword(){
        with(binding){
            etSignUpPasswordReconfirm.addTextChangedListener(object: TextWatcher{
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                    if(s.toString() != etSignUpPassword.text.toString() ){
                        textPasswordReconfirm.error = "비밀번호가 일치하지 않습니다."
                    } else{
                        textPasswordReconfirm.error = null
                        textPasswordReconfirm.isErrorEnabled = false
                        signUpViewModel.password.value = etSignUpPassword.text.toString()
                        imgSignUpPasswordNext.setOnClickListener {
                            val transaction = activity?.supportFragmentManager?.beginTransaction()
                            transaction?.apply {
                                replace(R.id.fragment_container_email, SignUpProfileFragment())
                                commit()
                            }
                        }
                    }
                }
            })
        }


    }


}