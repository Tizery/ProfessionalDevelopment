package com.example.professionaldevelopment.view.main

import com.example.professionaldevelopment.model.data.AppState
import com.example.professionaldevelopment.model.data.DataModel
import com.example.professionaldevelopment.model.repository.Repository
import com.example.professionaldevelopment.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}