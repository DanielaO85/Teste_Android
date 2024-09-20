package com.example.teste.repositories

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.teste.model.Album
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AlbumRepository(private val context: Context) {
    private val requestQueue: RequestQueue = Volley.newRequestQueue(context)
    private val gson = Gson()

    fun getAlbums(url: String, callback: (List<Album>?, String?) -> Unit) {
        val request = StringRequest(Request.Method.GET, url, { response ->
            val type = object : TypeToken<List<Album>>() {}.type
            val albums: List<Album> = gson.fromJson(response, type)
            callback(albums, null)
        }, { error ->
            callback(null, error.message)
        })
        requestQueue.add(request)
    }
}
