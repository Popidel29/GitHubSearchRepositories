package com.example.githubsearchrepositories.network

import com.example.githubsearchrepositories.model.RepositoryModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositorySearchClient {

    @GET(END_POINT)
    fun getRepository(@Query("q") searchRepositories: String): Observable<RepositoryModel>
}