package com.example.administratec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.administratec.databinding.ActivityGraficaGastosRecomendacionesBinding
import com.example.administratec.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationMenuView

class Grafica_Gastos_Recomendaciones : AppCompatActivity() {

    private lateinit var binding: ActivityGraficaGastosRecomendacionesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_grafica_gastos_recomendaciones)
        binding = ActivityGraficaGastosRecomendacionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        var navController = navHostFragment.navController
        setupWithNavController(binding.bottomNavigation, navController)
    }
}