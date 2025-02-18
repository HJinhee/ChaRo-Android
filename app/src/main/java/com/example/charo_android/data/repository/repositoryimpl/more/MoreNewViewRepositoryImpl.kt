package com.example.charo_android.data.repository.repositoryimpl.more

import com.example.charo_android.data.model.response.more.ResponseMoreViewData
import com.example.charo_android.data.repository.remote.more.RemoteMoreNewViewDataSource
import com.example.charo_android.domain.repository.moreview.MoreNewViewRepository

class MoreNewViewRepositoryImpl(private val dataSource: RemoteMoreNewViewDataSource) :
    MoreNewViewRepository {
    override suspend fun getMoreNewView(
        userEmail: String,
        identifer: String,
        value: String
    ): ResponseMoreViewData = dataSource.getMoreNewView(userEmail, identifer, value)
}