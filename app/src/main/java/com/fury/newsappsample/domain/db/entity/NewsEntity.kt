package com.fury.newsappsample.domain.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.fury.newsappsample.domain.db.typeConverters.NewsFeedConverter
import com.fury.newsappsample.response.Article

@Entity(tableName = "article_table")
class NewsEntity {

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0

    @TypeConverters(NewsFeedConverter::class)
    var articleList = arrayListOf<Article>()
}