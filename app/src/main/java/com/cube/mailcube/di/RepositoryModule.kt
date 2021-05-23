package com.cube.mailcube.di

import com.cube.mailcube.repository.ContentRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { ContentRepository(get()) }
}