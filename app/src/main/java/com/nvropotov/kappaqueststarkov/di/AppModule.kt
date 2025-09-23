package com.nvropotov.kappaqueststarkov.di

import android.app.Application
import com.nvropotov.kappaqueststarkov.data.database.QuestDatabase.Companion.getMainDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideQuestDao(application: Application) =
        getMainDatabase(application.applicationContext).dao()
}