package com.example.administratec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.administratec.databinding.ActivityMainBinding
import com.example.administratec.databinding.ActivityRegistro0Binding

class RegistroActivity0 : AppCompatActivity() {
    lateinit var binding: ActivityRegistro0Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_registro0)
        binding = ActivityRegistro0Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegistro.setOnClickListener {
            val intent: Intent = Intent(this, RegistroActivity1::class.java)
            startActivity(intent)
        }


    }
}