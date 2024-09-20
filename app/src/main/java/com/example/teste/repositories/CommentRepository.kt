package com.example.teste.repositories

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.teste.model.Comment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CommentRepository(private val context: Context) {
    private val requestQueue: RequestQueue = Volley.newRequestQueue(context)
    private val gson = Gson()

    fun getComments(url: String, callback: (List<Comment>?, String?) -> Unit) {
        val request = StringRequest(Request.Method.GET, url, { response ->
            val type = object : TypeToken<List<Comment>>() {}.type
            val comments: List<Comment> = gson.fromJson(response, type)
            callback(comments, null)  // Retorna os comentários
        }, { error ->
            callback(null, error.message)  // Retorna o erro
        })
        requestQueue.add(request)
    }
}
