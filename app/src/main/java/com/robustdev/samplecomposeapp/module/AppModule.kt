package com.robustdev.samplecomposeapp.module

import com.robustdev.samplecomposeapp.datasource.remote.PostRepo
import com.robustdev.samplecomposeapp.datasource.remote.PostRepository
import com.robustdev.samplecomposeapp.utils.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providePostRepo(): PostRepo {
        return PostRepository(RetrofitClient.api)
    }

}