package com.rafael.firstapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rafael.firstapplication.databinding.ActivityMainBinding

// Tela principal: campo de e-mail, campo de senha e botão.
// Ao clicar no botão, mostra os dois valores em um Toast.
class MainActivity : AppCompatActivity() {

    // Dá acesso aos itens do layout sem usar findViewById
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Carrega o layout activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)

        // Evita que o conteúdo fique embaixo das barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Pega os componentes da tela
        val editTextEmail = binding.editText
        val editTextPassword = binding.editTextPassword
        val button = binding.button

        // Quando clicar no botão
        button.setOnClickListener {
            // Pega o que foi digitado
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            // Monta a mensagem (\n pula a linha)
            val message = "Email: $email\nSenha: $password"

            // Mostra o Toast
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}