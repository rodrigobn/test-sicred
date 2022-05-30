package com.rodrigo.votosassociados.di

import com.rodrigo.votosassociados.data.repository.Repository
import com.rodrigo.votosassociados.data.repository.RepositoryImpl
import com.rodrigo.votosassociados.data.repository.local.pref.PreferencesHelper
import com.rodrigo.votosassociados.data.repository.network.BaseApi
import org.koin.dsl.module

val repositoryModule = module {
    single { provideRepository(get()) }
}

fun provideRepository(
    baseApi: BaseApi,
): Repository {
    return RepositoryImpl(baseApi)
}