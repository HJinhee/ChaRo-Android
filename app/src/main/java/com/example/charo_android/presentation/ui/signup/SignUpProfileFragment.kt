package com.example.charo_android.presentation.ui.signup

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.charo_android.R
import com.example.charo_android.databinding.FragmentSignUpProfileBinding
import com.example.charo_android.presentation.base.BaseFragment
import com.example.charo_android.presentation.ui.signup.viewmodel.SignUpEmailViewModel
import kotlinx.android.synthetic.main.fragment_sign_up_profile.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.regex.Pattern


class SignUpProfileFragment :
    BaseFragment<FragmentSignUpProfileBinding>(R.layout.fragment_sign_up_profile) {
    private val signUpViewModel: SignUpEmailViewModel by sharedViewModel()
    private val getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            signUpViewModel.profileImage.value = result.data?.data
            Log.d("imageProfile", signUpViewModel.profileImage.value.toString())

            Glide.with(this)
                .load(signUpViewModel.profileImage.value)
                .circleCrop()
                .into(binding.imgSignUpProfile)

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        checkNickName()
        registerProfile()
    }


    //닉네임 중복  체크
    private fun checkNickName() {
        val nickNamePattern = "^[가-힣ㄱ-ㅎ]{0,5}$"
        with(binding) {
            img_sign_up_profile_delete_button.setOnClickListener {
                etSignUpNickname.setText("")
            }

            etSignUpNickname.addTextChangedListener(object : TextWatcher {
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
                    if (s.toString().length > 5) {
                        textInputNickname.error = "5자 이내로 작성해주세요"
                    } else if (!Pattern.matches(nickNamePattern, s.toString())) {
                        textInputNickname.error = "한글만 사용해주세요"
                    } else {
                        signUpViewModel.nickNameCheck(s.toString())
                        signUpViewModel.nickNameCheck.observe(viewLifecycleOwner) {
                            if (!it) {
                                textInputNickname.error = "중복되는 닉네임이 존재합니다"
                            } else {
                                textInputNickname.error = null
                                textInputNickname.isErrorEnabled = false
                                textInputNickname.isHelperTextEnabled = true
                                textInputNickname.helperText = "사용 가능한 닉네임입니다"
                                signUpViewModel.nickName.value = etSignUpNickname.text.toString()

                                imgSignUpNicknameNext.setOnClickListener {
                                    val transaction =
                                        activity?.supportFragmentManager?.beginTransaction()
                                    transaction?.apply {
                                        replace(R.id.fragment_container_email, SignUpTermFragment())
                                        commit()
                                    }
                                }
                            }
                        }
                    }
                }
            })

        }
    }

    // 프로필 사진 등록
    private fun registerProfile() {
        binding.imgSignUpProfile.setOnClickListener {
            requestPermissions()
        }
    }

    private fun requestPermissions() {

        val permissions: Array<String> =
            arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)

        if (ContextCompat.checkSelfPermission(
                requireActivity(),
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
            != PackageManager.PERMISSION_GRANTED
        ){
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    requireActivity(),
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                )
            ) {
                Toast.makeText(requireActivity(), "앱 이용을 위해 저장소 권한을 허용해야 합니다.", Toast.LENGTH_SHORT).show()
                ActivityCompat.requestPermissions(requireActivity(), permissions, 1)
            } else {
                ActivityCompat.requestPermissions(requireActivity(), permissions, 0)
            }
        } else{
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = MediaStore.Images.Media.CONTENT_TYPE
            intent.type = "image/*"
            getContent.launch(intent)
        }



    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            0 -> {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(requireActivity(), "권한 허용", Toast.LENGTH_SHORT).show()
                    val intent = Intent(Intent.ACTION_PICK)
                    intent.type = MediaStore.Images.Media.CONTENT_TYPE
                    intent.type = "image/*"
                    getContent.launch(intent)
                } else {
                    Toast.makeText(requireActivity(), "앱 이용을 위해 권한 허용이 필요합니다.", Toast.LENGTH_SHORT).show()
                }
            }
            1 -> if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(requireActivity(), "권한 허용", Toast.LENGTH_SHORT).show()
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = MediaStore.Images.Media.CONTENT_TYPE
                intent.type = "image/*"
                getContent.launch(intent)
            } else {
                Toast.makeText(requireActivity(), "앱 이용을 위해 권한 허용이 필요합니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(Settings.ACTION_APPLICATION_SETTINGS)
                startActivity(intent)
            }
        }
    }




}