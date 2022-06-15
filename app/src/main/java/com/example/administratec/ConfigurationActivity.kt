package com.example.administratec

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.administratec.databinding.ActivityConfigurationBinding
import com.example.administratec.databinding.ActivityRegistro0Binding

class ConfigurationActivity : AppCompatActivity() {
    lateinit var binding: ActivityConfigurationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_configuration)
        binding = ActivityConfigurationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonGuardar.setOnClickListener {
            //Guardar como variable de la aplicación el presoupuesto deseado
            val presupuesto = binding.editPresupuesto.text.toString().toFloat()
            val preferences = this.getPreferences(Context.MODE_PRIVATE)
            with(preferences.edit()){
                putFloat("presupuesto_key", presupuesto)
                apply()
            }
            val intent: Intent = Intent(this, Grafica_Gastos_Recomendaciones::class.java)
            startActivity(intent)
        }

        binding.buttonSalir.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}