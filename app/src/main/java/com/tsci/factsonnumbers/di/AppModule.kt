package com.tsci.factsonnumbers.di

import com.tsci.cryptocurrencyapp.common.Constants
import com.tsci.factsonnumbers.data.remote.NumberFactsApi
import com.tsci.factsonnumbers.data.repository.NumberFactsRepository
import com.tsci.factsonnumbers.data.repository.NumberFactsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNumberFactsApi(): NumberFactsApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NumberFactsApi::class.java)
    }
    @Provides
    @Singleton
    fun provideNumberFactsRepository(api: NumberFactsApi): NumberFactsRepository{
        return NumberFactsRepositoryImpl(api)
    }
}