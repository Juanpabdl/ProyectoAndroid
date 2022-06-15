package com.example.administratec

import android.app.Application

class GastosApp: Application() {
    val database: AppDatabase by lazy {AppDatabase.getDatabase(this)}
}