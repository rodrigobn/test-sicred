package com.rodrigo.votosassociados.di

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rodrigo.votosassociados.BuildConfig
import com.rodrigo.votosassociados.data.deserializer.ScreenContentDeserializer
import com.rodrigo.votosassociados.data.model.Screen
import com.rodrigo.votosassociados.data.repository.network.BaseApi
import com.rodrigo.votosassociados.data.repository.network.BaseApiImpl
import com.rodrigo.votosassociados.data.repository.network.BaseService
import com.rodrigo.votosassociados.data.repository.network.helpers.NetworkHelper
import kotlinx.coroutines.Dispatchers
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

val netModule = module {
    factory { provideGson() }
    factory { provideLoggerInterceptor() }
    factory { provideCache(androidApplication()) }
    factory { NetworkHelper(get()) }

    single { provideRetrofit(get(), get()) }
    single { provideBaseService(get()) }
    single { provideBaseApi(get(), get()) }
    single { provideHttpClient(get(), get()) }
}

/**
 * Provide Retrofit instance.
 */
fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(factory))
        .build()
}

/**
 * Provide Cache instance used in OkHttpClient.
 */
fun provideCache(application: Application): Cache {
    val cacheSize = 10 * 1024 * 1024
    return Cache(application.cacheDir, cacheSize.toLong())
}

/**
 * Provide Gson instance used in Retrofit.
 */
fun provideGson(): Gson {
    return GsonBuilder()
        .registerTypeAdapter(Screen::class.java, ScreenContentDeserializer())
        .create()
}

/**
 * Provide http client security.
 */
fun provideHttpClient(cache: Cache, interceptor: Interceptor): OkHttpClient {
    return OkHttpClient
        .Builder()
        .cache(cache)
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)
        .addInterceptor(interceptor)
        .build()
}

/**
 * Provides Interceptor for logs used in OkHttpClient.
 */
fun provideLoggerInterceptor(): Interceptor {
    val logging = HttpLoggingInterceptor { message -> Timber.tag("OkHttp").d(message) }
    logging.level = HttpLoggingInterceptor.Level.BODY
    return logging
}

/**
 * Provide EventService instance.
 */
fun provideBaseService(retrofit: Retrofit): BaseService {
    return retrofit.create(BaseService::class.java)
}

/**
 * Provide EventApi instance.
 */
fun provideBaseApi(service: BaseService, networkHelper: NetworkHelper): BaseApi {
    return BaseApiImpl(service, networkHelper, Dispatchers.IO)
}