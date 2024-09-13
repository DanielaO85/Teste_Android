package com.example.teste

    import android.os.Bundle
    import android.widget.Button
    import android.widget.EditText
    import android.widget.TextView
    import androidx.appcompat.app.AppCompatActivity
    import java.text.NumberFormat

    class MainActivity4 : AppCompatActivity() {

        // Defina a taxa de conversão de Real para Dólar (pode ajustar conforme necessário)
        private val exchangeRate = 5.0 // Exemplo: 1 Dólar = 5 Reais

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main4)

            // Referência aos elementos do layout
            val inputReal: EditText = findViewById(R.id.inputReal)
            val buttonConvert: Button = findViewById(R.id.converte)
            val outputDollar: TextView = findViewById(R.id.outputDollar)

            // Configuração do botão de conversão
            buttonConvert.setOnClickListener {
                // Pega o valor digitado em Reais
                val realValue = inputReal.text.toString()

                // Verifica se o campo não está vazio
                if (realValue.isNotEmpty()) {
                    // Converte o valor para Double e realiza a conversão
                    val realAmount = realValue.toDouble()
                    val dollarAmount = realAmount / exchangeRate

                    // Formata o resultado para exibição como valor monetário
                    val formattedDollarAmount = NumberFormat.getCurrencyInstance().format(dollarAmount)

                    // Exibe o valor convertido em Dólares
                    outputDollar.text = "Valor em Dólares: $formattedDollarAmount"
                } else {
                    // Mostra uma mensagem se o campo estiver vazio
                    outputDollar.text = "Por favor, insira um valor."
                }
            }
        }
    }

