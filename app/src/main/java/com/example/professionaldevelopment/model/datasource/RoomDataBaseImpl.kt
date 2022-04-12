package com.example.professionaldevelopment.model.datasource

import com.example.professionaldevelopment.model.data.AppState
import com.example.professionaldevelopment.model.data.DataModel
import com.example.professionaldevelopment.room.HistoryDao
import com.example.professionaldevelopment.utils.convertDataModelSuccessToEntity
import com.example.professionaldevelopment.utils.mapHistoryEntityToSearchResult

class RoomDataBaseImpl(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}