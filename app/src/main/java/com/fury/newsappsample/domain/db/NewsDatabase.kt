package com.fury.newsappsample.domain.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fury.newsappsample.domain.db.dao.NewsArticleDao
import com.fury.newsappsample.domain.db.entity.NewsEntity

@Database(entities = arrayOf(NewsEntity::class),version = 1)
abstract class NewsDatabase : RoomDatabase(){

    abstract fun getNewsArticleDao() : NewsArticleDao

    companion object{
        private val LOCK = Any()
        private var instance : NewsDatabase? = null

        operator fun invoke(context: Context)  = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
        private fun buildDatabase(context: Context) : NewsDatabase {
            return Room.databaseBuilder(context.applicationContext,NewsDatabase::class.java,"news.db").fallbackToDestructiveMigration().build()
        }
    }
}