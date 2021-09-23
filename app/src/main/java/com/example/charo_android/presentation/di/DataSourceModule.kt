package com.example.charo_android.presentation.di

import com.example.charo_android.data.repository.remote.home.RemoteHomeDataSource
import com.example.charo_android.data.repository.remote.home.RemoteHomeDataSourceImpl
import com.example.charo_android.data.repository.remote.signup.RemoteSignUpEmailCheckDataSource
import com.example.charo_android.data.repository.remote.signup.RemoteSignUpEmailCheckDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<RemoteHomeDataSource>{ RemoteHomeDataSourceImpl(get()) }
    single<RemoteSignUpEmailCheckDataSource> { RemoteSignUpEmailCheckDataSourceImpl(get())}
}