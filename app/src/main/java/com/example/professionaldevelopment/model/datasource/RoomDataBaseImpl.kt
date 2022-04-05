package com.example.professionaldevelopment.model.datasource

import com.example.professionaldevelopment.model.data.DataModel

class RoomDataBaseImpl : DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}