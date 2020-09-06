package com.bolusarz.gap.di

import com.bolusarz.gap.data.remote.LearnerRemoteDataSource
import com.bolusarz.gap.data.remote.LearnerService
import com.bolusarz.gap.data.repositories.LearnerRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

const val BASE_URL = "https://gadsapi.herokuapp.com/api"

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient) : Retrofit =
        Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()


    @Provides
    fun provideLogger(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor { message ->
            run {
                Timber.tag("Http Requests")
                Timber.d(message)
            }
        }.setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun provideClient(logger: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
        .readTimeout(15, TimeUnit.SECONDS)
        .addInterceptor(logger)
        .build()

    @Provides
    fun provideLearnerService(retrofit: Retrofit): LearnerService =
        retrofit.create(LearnerService::class.java)

    @Provides
    fun provideLearnerRemoteDataSource(service: LearnerService): LearnerRemoteDataSource =
        LearnerRemoteDataSource(service)

    @Singleton
    @Provides
    fun provideRepository(dataSource: LearnerRemoteDataSource): LearnerRepository =
        LearnerRepository(dataSource)

}