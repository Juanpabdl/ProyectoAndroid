package com.example.administratec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin: Button = findViewById(R.id.buttonLogin)
        btnLogin.setOnClickListener {

            val intent: Intent = Intent(this, Grafica_Gastos_Recomendaciones::class.java)
            startActivity(intent)
        }
    }
}