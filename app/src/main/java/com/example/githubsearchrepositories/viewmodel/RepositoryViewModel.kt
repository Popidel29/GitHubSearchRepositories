package com.example.githubsearchrepositories.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubsearchrepositories.model.RepositoryModel
import com.example.githubsearchrepositories.repository.RepositorySearch
import io.reactivex.disposables.CompositeDisposable

class RepositoryViewModel(val repositorySearch: RepositorySearch) : ViewModel() {
    val repositoryLiveDataSuccess = MutableLiveData<RepositoryModel>()
    val repositoryLiveDataError = MutableLiveData<String>()
    private val compositeDisposable = CompositeDisposable()

    fun getRepositorySearch(repositoryName: String) {
        compositeDisposable.add(
            repositorySearch.getData(repositoryName).subscribe({ success ->
                repositoryLiveDataSuccess.value = success
            },
                { error -> repositoryLiveDataError.value = error.message })
        )
    }
}