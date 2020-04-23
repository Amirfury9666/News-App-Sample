package com.fury.newsappsample.domain.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fury.newsappsample.domain.db.entity.NewsEntity

@Dao
interface NewsArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticles(entity : NewsEntity)

    @Query("DELETE FROM article_table")
    fun deleteAllArticles()

    @Query("SELECT * FROM article_table")
    fun getAllArticles() : LiveData<NewsEntity>
}
