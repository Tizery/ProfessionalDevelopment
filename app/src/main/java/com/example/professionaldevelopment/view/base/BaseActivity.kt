package com.example.professionaldevelopment.view.base

import androidx.appcompat.app.AppCompatActivity
import com.example.professionaldevelopment.model.data.AppState
import com.example.professionaldevelopment.viewmodel.BaseViewModel

abstract class BaseActivity<T : AppState> : AppCompatActivity() {

    abstract val model: BaseViewModel<T>

    abstract fun renderData(appState: T)
}