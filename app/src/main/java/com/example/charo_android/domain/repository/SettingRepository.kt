package com.example.charo_android.domain.repository

import com.example.charo_android.data.model.response.setting.ResponseProfileUpdateData
import com.example.charo_android.domain.model.setting.ProfileChangeData
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface SettingRepository {
    suspend fun profileChange(
        userEmail : String,
        image : MultipartBody.Part,
        originImage : RequestBody,
        newNickname : RequestBody
    ) : ProfileChangeData

    suspend fun nickNameChange(
        userEmail: String,
        profileImage : RequestBody,
        newNickname: RequestBody
    ) : ProfileChangeData
}