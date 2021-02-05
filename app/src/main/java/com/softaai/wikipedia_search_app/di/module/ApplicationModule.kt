package com.softaai.wikipedia_search_app.di.module

import android.content.Context
import com.softaai.wikipedia_search_app.network.RequestInterceptor
import com.softaai.wikipedia_search_app.network.WikipediaApiClient
import com.softaai.wikipedia_search_app.network.WikipediaApiService
import com.softaai.wikipedia_search_app.persistence.WikiSearchResponseDao
import com.softaai.wikipedia_search_app.persistence.WikiSearchRoomDb
import com.softaai.wikipedia_search_app.repository.WikiSearchRepository
import com.softaai.wikipedia_search_app.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder().addInterceptor(RequestInterceptor()).build();



    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(WikipediaApiService::class.java)

    @Provides
    @Singleton
    fun provideApiClient(wikipediaApiService: WikipediaApiService): WikipediaApiClient = WikipediaApiClient(wikipediaApiService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): WikiSearchRoomDb = WikiSearchRoomDb.getWikiSearchDatabase(appContext)

    @Singleton
    @Provides
    fun provideWikiSearchDao(db: WikiSearchRoomDb): WikiSearchResponseDao = db.wikiSearchDao()

    @Singleton
    @Provides
    fun provideWikiSearchRepository(wikipediaApiClient: WikipediaApiClient, wikiSearchResponseDao: WikiSearchResponseDao) =
        WikiSearchRepository(wikipediaApiClient, wikiSearchResponseDao)
}