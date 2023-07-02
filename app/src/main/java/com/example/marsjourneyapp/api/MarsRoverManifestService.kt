package com.example.marsjourneyapp.api

import com.example.marsjourneyapp.BuildConfig
import com.example.marsjourneyapp.api.model.RoverManifestRemoteModel
import com.example.marsjourneyapp.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by AralBenli on 2.07.2023.
 */
interface MarsRoverManifestService {

    @GET("mars-photos/api/v1/manifest/{rover_name}?api_key=${Constants.API_KEY}")
    suspend fun getMarsRoverManifest(
        @Path("rover_name") roverName: String
    ): RoverManifestRemoteModel


    companion object {
        private const val BASE_URL = "https://api.nasa.gov/"

        fun create(): MarsRoverManifestService {
            val logger = HttpLoggingInterceptor()
            logger.level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MarsRoverManifestService::class.java)
        }
    }

}