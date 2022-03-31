package com.tsci.factsonnumbers.di

import android.content.Context
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.core.content.ContextCompat
import com.tsci.cryptocurrencyapp.common.Constants
import com.tsci.factsonnumbers.data.remote.NumberFactsApi
import com.tsci.factsonnumbers.data.repository.NumberFactsRepository
import com.tsci.factsonnumbers.data.repository.NumberFactsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Headers
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Headers("Content-Type: text/html")
    @Singleton
    fun provideNumberFactsApi(): NumberFactsApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
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