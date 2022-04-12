package com.example.professionaldevelopment.di

import androidx.room.Room
import com.example.professionaldevelopment.model.data.DataModel
import com.example.professionaldevelopment.model.datasource.RetrofitImpl
import com.example.professionaldevelopment.model.datasource.RoomDataBaseImpl
import com.example.professionaldevelopment.model.repository.Repository
import com.example.professionaldevelopment.model.repository.RepositoryImpl
import com.example.professionaldevelopment.model.repository.RepositoryImplementationLocal
import com.example.professionaldevelopment.model.repository.RepositoryLocal
import com.example.professionaldevelopment.room.HistoryDataBase
import com.example.professionaldevelopment.view.history.HistoryInteractor
import com.example.professionaldevelopment.view.history.HistoryViewModel
import com.example.professionaldevelopment.view.main.MainInteractor
import com.example.professionaldevelopment.view.main.MainViewModel
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImpl(RetrofitImpl()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(RoomDataBaseImpl(get()))
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}