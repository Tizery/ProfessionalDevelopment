package com.example.professionaldevelopment.di

import com.example.professionaldevelopment.model.data.DataModel
import com.example.professionaldevelopment.model.datasource.RetrofitImpl
import com.example.professionaldevelopment.model.datasource.RoomDataBaseImpl
import com.example.professionaldevelopment.model.repository.Repository
import com.example.professionaldevelopment.model.repository.RepositoryImpl
import com.example.professionaldevelopment.view.main.MainInteractor
import com.example.professionaldevelopment.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) { RepositoryImpl(RetrofitImpl()) }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) { RepositoryImpl(RoomDataBaseImpl()) }
}

val mainScreen = module {
    factory { MainInteractor(
        repositoryRemote = get(named(NAME_REMOTE)),
        repositoryLocal = get(named(NAME_LOCAL))
    ) }
    factory { MainViewModel(interactor = get()) }
}