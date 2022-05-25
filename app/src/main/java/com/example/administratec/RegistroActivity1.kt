package com.example.administratec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.administratec.databinding.ActivityRegistro1Binding

class RegistroActivity1 : AppCompatActivity() {
    lateinit var binding: ActivityRegistro1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_registro1)
        binding = ActivityRegistro1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSeguir.setOnClickListener{
            val intent: Intent = Intent(this, RegistroActivity2::class.java)
            startActivity(intent)
        }

        binding.buttonRegresar.setOnClickListener{
            val intent: Intent = Intent(this, RegistroActivity0::class.java)
            startActivity(intent)
        }


    }
}