package com.example.teste.repositories

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.teste.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UserRepository(private val context: Context) {
    private val requestQueue: RequestQueue = Volley.newRequestQueue(context)
    private val gson = Gson()

    fun getUsers(url: String, callback: (List<User>?, String?) -> Unit) {
        val request = StringRequest(Request.Method.GET, url, { response ->
            val type = object : TypeToken<List<User>>() {}.type
            val users: List<User> = gson.fromJson(response, type)
            callback(users, null)  // Retorna os usuários
        }, { error ->
            callback(null, error.message)  // Retorna o erro
        })
        requestQueue.add(request)
    }
}
