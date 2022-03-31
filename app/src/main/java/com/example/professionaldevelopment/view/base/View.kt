package com.example.professionaldevelopment.view.base

import com.example.professionaldevelopment.model.data.AppState

interface View {

    fun renderData(appState: AppState)

}