package com.softaai.wikipedia_search_app.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.softaai.wikipedia_search_app.model.Page


@Database(entities = arrayOf(Page::class), version = 1, exportSchema = false)
abstract class WikiSearchRoomDb : RoomDatabase() {

    abstract fun wikiSearchDao(): WikiSearchResponseDao

    companion object {

        @Volatile
        private var INSTANCE: WikiSearchRoomDb? = null

        fun getWikiSearchDatabase(context: Context): WikiSearchRoomDb {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WikiSearchRoomDb::class.java,
                    "wikisearch_database"
                ).build()
                INSTANCE = instance

                instance
            }
        }
    }
}