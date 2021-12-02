package com.example.graphqlsample.persenter.ui.repositories

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.graphqlsample.domain.interceptor.GetRepository
import com.example.graphqlsample.persenter.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel
@Inject
constructor(
    getRepositoryInterceptor: GetRepository,
) : BaseViewModel() {

    var getRepository =
        getRepositoryInterceptor.execute(size = 100).asLiveData(viewModelScope.coroutineContext)

}