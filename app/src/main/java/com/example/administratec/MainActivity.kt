package com.example.administratec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.administratec.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //El boton Iniciar Sesion cambia a la pantalla Login
        //val btnIniciarSesion: Button = findViewById(R.id.buttonInicio)
        binding.buttonInicio.setOnClickListener {
            val intent: Intent = Intent (this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.buttonRegistro.setOnClickListener {
            val intent: Intent = Intent (this, RegistroActivity0::class.java)
            startActivity(intent)
        }




    }
}