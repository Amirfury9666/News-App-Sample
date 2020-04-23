package com.fury.newsappsample.util

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.*

fun Context.toast(message : String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}

fun View.hide(){
   visibility =  View.GONE
}

fun View.show(){
  visibility =  View.VISIBLE
}

fun printError(tag : String, message: String){
    Log.e(tag,message)
}


inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object : TypeToken<T>() {}.type)
inline fun <reified T : Any> T.json(): String = Gson().toJson(this, T::class.java)


fun <T> lazyDefered(block : suspend CoroutineScope.() -> T) : Lazy<Deferred<T>>{
    return lazy {
        GlobalScope.async(start = CoroutineStart.LAZY){
            block.invoke(this)
        }
    }
}