package com.example.marsjourneyapp.di

import com.example.marsjourneyapp.api.MarsRoverManifestService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by AralBenli on 2.07.2023.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesMarsRoverManifestService() : MarsRoverManifestService =
        MarsRoverManifestService.create()
}