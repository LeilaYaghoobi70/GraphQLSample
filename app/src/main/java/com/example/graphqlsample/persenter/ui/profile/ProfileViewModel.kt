package com.example.graphqlsample.persenter.ui.profile

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.graphqlsample.domain.interceptor.GetProfile
import com.example.graphqlsample.persenter.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel
@Inject
constructor(
    getProfileInterceptor: GetProfile,
) : BaseViewModel() {
    var getProfile = getProfileInterceptor.execute().asLiveData(viewModelScope.coroutineContext)
}