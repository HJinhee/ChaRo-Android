package com.example.charo_android.presentation.util

import androidx.lifecycle.MutableLiveData

class NonNullMutableLiveData<T : Any>(value: T) : NonNullLiveData<T>(value) {
    public override fun setValue(value: T) {
        super.setValue(value)
    }

    public override fun postValue(value: T) {
        super.postValue(value)
    }
}