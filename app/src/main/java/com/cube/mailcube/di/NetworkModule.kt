package com.cube.mailcube.di

import com.cube.mailcube.BuildConfig
import com.cube.mailcube.api.MailCubeNetworkService
import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

val netWorkModule = module {
    single{
        GsonBuilder()
            .setLenient()
            .create()
    }

    single {
        GsonConverterFactory.create(get())
    }

    single {
        ScalarsConverterFactory.create()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(get<ScalarsConverterFactory>())
            .addConverterFactory(get<GsonConverterFactory>())
            .build()
    }

    single {
        get<Retrofit>().create(MailCubeNetworkService::class.java)
    }
}