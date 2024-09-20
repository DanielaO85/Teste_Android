package com.example.teste.repositories

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.teste.model.Todo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TodoRepository(private val context: Context) {
    private val requestQueue: RequestQueue = Volley.newRequestQueue(context)
    private val gson = Gson()

    fun getTodos(url: String, callback: (List<Todo>?, String?) -> Unit) {
        val request = StringRequest(Request.Method.GET, url, { response ->
            val type = object : TypeToken<List<Todo>>() {}.type
            val todos: List<Todo> = gson.fromJson(response, type)
            callback(todos, null)
        }, { error ->
            callback(null, error.message)
        })
        requestQueue.add(request)
    }
}
