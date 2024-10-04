package com.example.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    // Initialize card views
    private lateinit var cardHome: CardView
    private lateinit var cardChat: CardView
    private lateinit var cardProfile: CardView
    private lateinit var cardWidget: CardView
    private lateinit var cardSettings: CardView
    private lateinit var cardLogout: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize card views by finding corresponding views from layout
        cardHome = findViewById(R.id.cardHome)
        cardChat = findViewById(R.id.cardChat)
        cardProfile = findViewById(R.id.cardProfile)
        cardWidget = findViewById(R.id.cardWidget)
        cardSettings = findViewById(R.id.cardSettings)
        cardLogout = findViewById(R.id.cardLogout)

        cardHome.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        cardChat.setOnClickListener{
            showToast("Messages Clicked!")
        }
        cardProfile.setOnClickListener{
            showToast("Profile Clicked!")
        }
        cardWidget.setOnClickListener{
            showToast("Widget Clicked!")
        }
        cardSettings.setOnClickListener{
            showToast("Settings Clicked!")
        }
        cardLogout.setOnClickListener{
            Firebase.auth.signOut()
            startActivity(Intent(this, SignIn::class.java))
            showToast("You have been signed out!")
        }
    }

    private fun showToast(message: String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

}