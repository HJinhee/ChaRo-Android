package com.example.charo_android.data.api.signup

import com.example.charo_android.data.model.response.signup.ResponseRegisterData
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface SignUpRegisterService {
    @Multipart
    @POST("/user/register")
    suspend fun signUpRegister(
        @Part image : MultipartBody.Part,
        @Part ("userEmail") userEmail: RequestBody,
        @Part("password") password: RequestBody,
        @Part("nickname") nickname : RequestBody,
        @Part("pushAgree") pushAgree : RequestBody,
        @Part("emailAgree") emailAgree : RequestBody,

        ) : ResponseRegisterData
}
