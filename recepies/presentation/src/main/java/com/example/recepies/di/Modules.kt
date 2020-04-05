package com.example.recepies.di

import com.example.recepies.ui.home.HomeFragment
import com.example.recepies.ui.home.HomePresenter
import com.example.recepies.ui.home.HomeView
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    scope(named<HomeFragment>()) {
        scoped { (view: HomeView) -> HomePresenter(view) }
    }
}