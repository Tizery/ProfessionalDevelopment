package com.example.professionaldevelopment.model.datasource

import com.example.professionaldevelopment.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}