package com.example.teste

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Referência para os botões
        val buttonScreen1: Button = findViewById(R.id.botaopcao1)

        // Configura o botão para ir para a Tela 3
        buttonScreen1.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }


    }
}
