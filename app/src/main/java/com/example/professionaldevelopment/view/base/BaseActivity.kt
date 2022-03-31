package com.example.professionaldevelopment.view.base

import androidx.appcompat.app.AppCompatActivity
import com.example.professionaldevelopment.model.data.AppState
import com.example.professionaldevelopment.viewmodel.BaseViewModel
import com.example.professionaldevelopment.viewmodel.Interactor

abstract class BaseActivity<T : AppState, I : Interactor<T>> : AppCompatActivity() {

    abstract val model: BaseViewModel<T>

    abstract fun renderData(appState: T)
}