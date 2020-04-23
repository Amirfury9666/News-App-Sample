package com.fury.newsappsample.domain.db.typeConverters

import androidx.room.TypeConverter
import com.fury.newsappsample.response.Article
import com.fury.newsappsample.util.fromJson
import com.fury.newsappsample.util.json
import com.google.gson.Gson

class NewsFeedConverter {
    @TypeConverter
    fun convertToString(list: ArrayList<Article>?) : String {
        list?: return ""
        return list.json()
    }

    @TypeConverter
    fun convertToList(value : String) : ArrayList<Article> {
        if (value.isNullOrEmpty()){
            return arrayListOf()
        }
        return Gson().fromJson<ArrayList<Article>>(value)
    }
}