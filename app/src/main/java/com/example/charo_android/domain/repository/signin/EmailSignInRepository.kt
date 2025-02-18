package com.example.charo_android.domain.repository.signin

import com.example.charo_android.data.model.request.signin.RequestSignInData
import com.example.charo_android.data.model.response.signin.ResponseSignInData
import com.example.charo_android.domain.model.signin.EmailSignInData

interface EmailSignInRepository {
    suspend fun postSignIn(requestSignInData: RequestSignInData) : EmailSignInData
}