package com.example.teste

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

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
        }
       // val intent = Intent(this, MainActivity2::class.java)
       // startActivity(intent)

    }
}