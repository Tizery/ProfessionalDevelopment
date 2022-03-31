package com.example.professionaldevelopment.presenter

import com.example.professionaldevelopment.model.data.AppState
import com.example.professionaldevelopment.view.base.View

interface Presenter<T : AppState, V : View> {
    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}
