package com.pixelcarrot.broccoli.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.pixelcarrot.broccoli.data.local.dao.AlbumDao
import com.pixelcarrot.broccoli.data.local.dao.SongDao
import com.pixelcarrot.broccoli.data.local.database.AppDatabase
import com.pixelcarrot.broccoli.data.remote.api.SpotifyApi
import com.pixelcarrot.broccoli.util.LenientTypeAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    private const val BASE_URL = "http://localhost:8080/"
    private const val DATABASE = "app.db"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapterFactory(LenientTypeAdapterFactory())
            .create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideSpotifyApi(retrofit: Retrofit): SpotifyApi {
        return retrofit.create(SpotifyApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context = context.applicationContext,
            klass = AppDatabase::class.java,
            name = DATABASE,
        ).build()
    }

    @Singleton
    @Provides
    fun provideSongDao(database: AppDatabase): SongDao {
        return database.songDao()
    }

    @Singleton
    @Provides
    fun provideAlbumDao(database: AppDatabase): AlbumDao {
        return database.albumDao()
    }

}
