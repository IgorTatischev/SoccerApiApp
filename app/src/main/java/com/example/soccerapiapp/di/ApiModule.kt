package com.example.soccerapiapp.di

import com.example.soccerapiapp.featur_soccer.data.remote.SoccerApiService
import com.example.soccerapiapp.featur_soccer.data.repository.SoccerRepositoryImpl
import com.example.soccerapiapp.featur_soccer.domain.repository.SoccerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    private const val BASE_URL = "https://apiv2.allsportsapi.com/football/?"

    @Singleton
    @Provides
    fun providesHttpLoginInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun providesSoccerApiService(retrofit: Retrofit) = retrofit.create(SoccerApiService::class.java)

    @Provides
    @Singleton
    fun provideHotelRepository(soccerApiService: SoccerApiService): SoccerRepository {
        return SoccerRepositoryImpl(soccerApiService)
    }
}