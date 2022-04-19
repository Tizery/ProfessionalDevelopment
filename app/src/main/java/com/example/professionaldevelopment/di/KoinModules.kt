package com.example.professionaldevelopment.di

import androidx.room.Room
import com.example.historyscreen.view.history.HistoryActivity
import com.example.historyscreen.view.history.HistoryInteractor
import com.example.historyscreen.view.history.HistoryViewModel
import com.example.model.data.DataModel
import com.example.professionaldevelopment.view.main.MainActivity
import com.example.professionaldevelopment.view.main.MainInteractor
import com.example.professionaldevelopment.view.main.MainViewModel
import com.example.repository.*
import com.example.repository.room.HistoryDataBase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImpl(RetrofitImpl()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(RoomDataBaseImpl(get()))
    }
}


val mainScreen = module {
    scope(named<MainActivity>()) {
        scoped { MainInteractor(get(), get()) }
        viewModel { MainViewModel(get()) }
    }
}

val historyScreen = module {
    scope(named<HistoryActivity>()) {
        scoped { HistoryInteractor(get(), get()) }
        viewModel { HistoryViewModel(get()) }
    }
}