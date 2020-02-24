package com.example.githubsearchrepositories.repository

import com.example.githubsearchrepositories.model.RepositoryModel
import io.reactivex.Observable

interface RepositorySearch {
fun getData(repositoryData:String): Observable<RepositoryModel>
}