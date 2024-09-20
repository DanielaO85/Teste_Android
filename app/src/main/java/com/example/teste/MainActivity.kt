package com.example.teste

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.teste.repositories.UserRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Referência para os botões
        val buttonScreen1: Button = findViewById(R.id.botaoiniciar)

        // Configura o botão para ir para a Tela 1
        buttonScreen1.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

            // Testando models
            val userRepository = UserRepository(this)
            val url = "https://jsonplaceholder.typicode.com/users"  // Exemplo de URL

            userRepository.getUsers(url) { users, error ->
                if (error != null) {
                    println("Erro: $error")
                } else {
                    users?.forEach { user ->
                        println(user.name)
                    }
                }
            }

        }

    }
}