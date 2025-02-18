package com.example.charo_android.data.mapper

import com.example.charo_android.data.model.request.RequestCertificationData
import com.example.charo_android.data.model.response.ResponseStatusCode
import com.example.charo_android.data.model.response.signup.*
import com.example.charo_android.domain.model.StatusCode
import com.example.charo_android.domain.model.signup.Email
import com.example.charo_android.domain.model.signup.EmailCheck
import com.example.charo_android.domain.model.signup.SocialSignUp

object SignUpMapper {
    fun mapperToEmailCheck(responseEmailCheckData: ResponseEmailCheckData) : Boolean {
        return responseEmailCheckData.success
    }


    fun mapperToEmailCertification(responseEmailCertificationData: ResponseCertificationData) : String{
        return responseEmailCertificationData.data

    }

    fun mapperToRegister(responseRegisterData: ResponseRegisterData) : Boolean{
        return responseRegisterData.success
    }

    fun mapperToNickNameCheck(responseNickNameCheckData: ResponseNickNameCheckData) : Boolean{
        return responseNickNameCheckData.success
    }

    fun mapperToSocialSignUp(responseStatusCode: ResponseStatusCode) : StatusCode{
        return StatusCode(
            success = responseStatusCode.success
        )

    }
}