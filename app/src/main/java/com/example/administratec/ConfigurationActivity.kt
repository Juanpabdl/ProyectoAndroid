package com.example.administratec

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.administratec.databinding.ActivityConfigurationBinding
//import com.example.administratec.databinding.ActivityRegistro0Binding

class ConfigurationActivity : AppCompatActivity() {
    lateinit var binding: ActivityConfigurationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_configuration)
        binding = ActivityConfigurationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonGuardar.setOnClickListener {
            //Guardar como variable de la aplicación el presoupuesto deseado
            if(binding.editPresupuesto.text.toString().isEmpty()){
                Toast.makeText(this,"Por favor, defina el presupuesto", Toast.LENGTH_SHORT).show()
            }else {
                val presupuesto = binding.editPresupuesto.text.toString().toFloat()
                val preferences = this.getPreferences(Context.MODE_PRIVATE)
                var compraPercent: Float = preferences.getInt("compras_key",20).toFloat()
                var casaPercent: Float = preferences.getInt("casa_key",25).toFloat()
                var elecPercent: Float = preferences.getInt("electronicos_key",15).toFloat()
                var alimentoPercent: Float = preferences.getInt("alimantacion_key",20).toFloat()
                var eduPercent: Float = preferences.getInt("educacion_key",20).toFloat()

                val maxCompra = presupuesto * (compraPercent/100)
                val maxCasa = presupuesto * (casaPercent/100)
                val maxElec = presupuesto * (elecPercent/100)
                val maxAlimento = presupuesto * (alimentoPercent/100)
                val maxEdu = presupuesto * (eduPercent/100)
                //Log.i("MAX",maxCompra.toString() + " " + maxCasa.toString() + " " + maxElec.toString() + " " + maxAlimento.toString() + " " + maxEdu.toString())

                with(preferences.edit()) {
                    putFloat("presupuesto_key", presupuesto)
                    putFloat("max_compra_key", maxCompra)
                    putFloat("max_casa_key",maxCasa)
                    putFloat("max_electronico_key",maxElec)
                    putFloat("max_alimentacion_key",maxAlimento)
                    putFloat("max_educacion_key",maxEdu)
                    apply()
                }

                Toast.makeText(this,"Presupuesto guardado", Toast.LENGTH_SHORT).show()
                val intent: Intent = Intent(this, Grafica_Gastos_Recomendaciones::class.java)
                startActivity(intent)
            }
        }

        binding.buttonSalir.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}