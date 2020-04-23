package com.fury.newsappsample.response


import android.content.Intent
import android.view.View
import androidx.room.Embedded
import com.fury.newsappsample.ui.DetailsActivity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Article(
    @SerializedName("author")
    val author: String?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("description")
    val description: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("source")
    @Embedded(prefix = "source_")
    val source: Source,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String?
) : Serializable{


    fun onItemClick(view : View){
      val intent =   Intent(view.context,DetailsActivity::class.java).also {
            it.putExtra("image",urlToImage)
            it.putExtra("title",title)
            it.putExtra("content",content)
        }
        view.context.startActivity(intent)
    }
}