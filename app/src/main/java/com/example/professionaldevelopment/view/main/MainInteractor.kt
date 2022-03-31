package com.example.professionaldevelopment.view.main

import com.example.professionaldevelopment.di.NAME_LOCAL
import com.example.professionaldevelopment.di.NAME_REMOTE
import com.example.professionaldevelopment.model.data.AppState
import com.example.professionaldevelopment.model.data.DataModel
import com.example.professionaldevelopment.model.repository.Repository
import com.example.professionaldevelopment.viewmodel.Interactor
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class MainInteractor @Inject constructor(
    @Named(NAME_REMOTE) val repositoryRemote: Repository<List<DataModel>>,
    @Named(NAME_LOCAL) val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            repositoryRemote.getData(word).map { AppState.Success(it) }
        } else {
            repositoryLocal.getData(word).map { AppState.Success(it) }
        }
    }
}