package com.example.teste.repositories

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.teste.model.Post
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PostRepository(private val context: Context) {
    private val requestQueue: RequestQueue = Volley.newRequestQueue(context)
    private val gson = Gson()

    fun getPosts(url: String, callback: (List<Post>?, String?) -> Unit) {
        val request = StringRequest(Request.Method.GET, url, { response ->
            val type = object : TypeToken<List<Post>>() {}.type
            val posts: List<Post> = gson.fromJson(response, type)
            callback(posts, null)  // Retorna os posts
        }, { error ->
            callback(null, error.message)  // Retorna o erro
        })
        requestQueue.add(request)
    }
}
