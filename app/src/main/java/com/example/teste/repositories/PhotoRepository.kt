package com.example.teste.repositories

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.teste.model.Photo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PhotoRepository(private val context: Context) {
    private val requestQueue: RequestQueue = Volley.newRequestQueue(context)
    private val gson = Gson()

    fun getPhotos(url: String, callback: (List<Photo>?, String?) -> Unit) {
        val request = StringRequest(Request.Method.GET, url, { response ->
            val type = object : TypeToken<List<Photo>>() {}.type
            val photos: List<Photo> = gson.fromJson(response, type)
            callback(photos, null)
        }, { error ->
            callback(null, error.message)
        })
        requestQueue.add(request)
    }
}
