package com.example.professionaldevelopment.view.main

import com.example.professionaldevelopment.model.data.AppState
import com.example.professionaldevelopment.model.data.DataModel
import com.example.professionaldevelopment.model.repository.Repository
import com.example.professionaldevelopment.viewmodel.Interactor
import io.reactivex.Observable

class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}