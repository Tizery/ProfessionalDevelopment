package com.example.professionaldevelopment.model.datasource

import com.example.professionaldevelopment.model.data.DataModel
import io.reactivex.Observable

class DataSourceRemote(private val remoteProvider: RetrofitImpl= RetrofitImpl()) :
    DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)
}
