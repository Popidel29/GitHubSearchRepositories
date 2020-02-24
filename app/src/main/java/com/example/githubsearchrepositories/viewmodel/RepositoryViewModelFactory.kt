package com.example.githubsearchrepositories.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubsearchrepositories.repository.RepositorySearch

class RepositoryViewModelFactory(private val repositorySearch: RepositorySearch) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RepositoryViewModel(repositorySearch) as T
    }
}