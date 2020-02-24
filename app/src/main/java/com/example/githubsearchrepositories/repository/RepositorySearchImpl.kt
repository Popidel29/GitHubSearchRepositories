package com.example.githubsearchrepositories.repository

import com.example.githubsearchrepositories.model.RepositoryModel
import com.example.githubsearchrepositories.network.RetrofitClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepositorySearchImpl :
    RepositorySearch {

    private val retrofitClient = RetrofitClient.getRetrofitInstance

    override fun getData(repositoryData: String): Observable<RepositoryModel> {
        return retrofitClient.getRepository(repositoryData).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}