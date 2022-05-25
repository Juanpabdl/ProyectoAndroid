package com.example.administratec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.administratec.databinding.ActivityRegistro2Binding

class RegistroActivity2 : AppCompatActivity() {
    lateinit var binding : ActivityRegistro2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_registro2)
        binding = ActivityRegistro2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonRegresar.setOnClickListener{
            val intent: Intent = Intent(this, RegistroActivity1::class.java)
            startActivity(intent)
        }

        binding.buttonTerminar.setOnClickListener {
            val intent: Intent = Intent(this, Grafica_Gastos_Recomendaciones::class.java)
            startActivity(intent)
        }


    }
}