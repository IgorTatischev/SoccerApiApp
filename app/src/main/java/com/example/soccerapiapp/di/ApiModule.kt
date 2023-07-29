package com.example.soccerapiapp.di

import com.example.soccerapiapp.featur_soccer.data.remote.SoccerApiService
import com.example.soccerapiapp.featur_soccer.data.repository.SoccerRepositoryImpl
import com.example.soccerapiapp.featur_soccer.domain.repository.SoccerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
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
    fun providesAuthInterceptor() = Interceptor.invoke { chain ->
        val url = chain
            .request()
            .url
            .newBuilder()
            .addQueryParameter("APIkey", "32808309af0f07278ab88904c4b89294ea9f9ac8bd4b494cedc04d59cd256982")
            .build()
        chain.proceed(chain.request().newBuilder().url(url).build())
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, authInterceptor: Interceptor) = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
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

//    @Provides
//    @Singleton
//    fun provideOkHttpClient(): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor { chain ->
//                val url = chain
//                    .request()
//                    .url
//                    .newBuilder()
//                    .addQueryParameter("APIkey", "e45b2a8c9c8527b8de7d5d7ed5961f5086f80d8d32867b63b84deddf61cb9a47")
//                    .build()
//                chain.proceed(chain.request().newBuilder().url(url).build())
//            }
//            //add timeouts, logging
//            .also { okHttpClient ->
//                if (BuildConfig.DEBUG) {
//                    val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
//                        level = HttpLoggingInterceptor.Level.BODY
//                    }
//                    okHttpClient.addInterceptor(httpLoggingInterceptor)
//                }
//            }
//            .build()
//    }