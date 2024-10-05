package com.example.firebaseauth

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    private lateinit var cardRegPatient: CardView
    private lateinit var cardViewPatients: CardView
    private lateinit var cardSearchPatient: CardView
    private lateinit var cardVaccination: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        cardRegPatient = findViewById(R.id.cardRegPatient)
        cardSearchPatient = findViewById(R.id.cardSearchPatient)
        cardViewPatients = findViewById(R.id.cardViewPatients)
        cardVaccination = findViewById(R.id.cardVaccination)

        cardVaccination.setOnClickListener {
            val intent = Intent(this, CovidVaccine::class.java)
            startActivity(intent)
        }
    }
}