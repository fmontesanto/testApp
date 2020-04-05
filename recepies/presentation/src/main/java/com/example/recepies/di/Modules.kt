package com.example.recepies.di

import com.example.data.Repository
import com.example.data.mapper.Mapper
import com.example.data.remote.RetrofitClient
import com.example.data.remote.api.ApiClientProd
import com.example.recepies.ui.home.HomeFragment
import com.example.recepies.ui.home.HomePresenter
import com.example.recepies.ui.home.HomeView
import com.example.usecase.usecases.SearchRecipes
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    scope(named<HomeFragment>()) {
        scoped { (view: HomeView) -> HomePresenter(view, get()) }
    }
}

val dataModule = module {
    single { RetrofitClient.build(ApiClientProd.Companion.BASE_URL) }
    single (named("apiClient")) { ApiClientProd(get())  }
    single { Mapper() }
    factory { Repository( get(qualifier = named("apiClient")), get()) }
}

val useCaseModule = module {
    factory { SearchRecipes(get()) }
}