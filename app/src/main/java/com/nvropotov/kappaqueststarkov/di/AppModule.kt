package com.nvropotov.kappaqueststarkov.di

import android.app.Application
import com.nvropotov.kappaqueststarkov.data.QuestRepositoryImpl
import com.nvropotov.kappaqueststarkov.data.database.QuestDao
import com.nvropotov.kappaqueststarkov.data.database.QuestDatabase.Companion.getMainDatabase
import com.nvropotov.kappaqueststarkov.data.network.QuestApi
import com.nvropotov.kappaqueststarkov.domain.repository.QuestRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://raw.githubusercontent.com/"

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideQuestDao(application: Application) =
        getMainDatabase(application.applicationContext).dao()

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    fun provideQuestApi(
        okHttpClient: OkHttpClient,
    ): QuestApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestApi::class.java)

    @Provides
    fun provideQuestRepository(
        questApi: QuestApi,
        questDao: QuestDao,
    ): QuestRepository =
        QuestRepositoryImpl(questApi, questDao)
}