package com.example.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

private lateinit var auth: FirebaseAuth

class SignIn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        val emailEditText = findViewById<EditText>(R.id.etSignInEmail)
        val passwordEditText = findViewById<EditText>(R.id.etSignInPassword)

        val clickSignIn = findViewById<Button>(R.id.btnSignIn)
        clickSignIn.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                signIn(email, password)
            } else {
                Toast.makeText(
                    baseContext,
                    "Please fill in both email and password.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val clickCreateAccount = findViewById<Button>(R.id.btnCreateAccount2)
        clickCreateAccount.setOnClickListener {
            val intent = Intent(this, CreateAccount::class.java)
            startActivity(intent)
        }
    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }
            }
    }

    private fun updateUI(user: FirebaseUser?) {
        // TODO: Implement what should happen after a successful sign-in
        // For example, navigate to another activity or display user information
        if (user != null) {
            // User is signed in, navigate to the main activity, etc.
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(
                baseContext,
                "Congratulations you have signed in successfully!",
                Toast.LENGTH_SHORT
            ).show()
            finish() //to prevent going back
        } else {
            // User is not signed in, handle accordingly
            Toast.makeText(
                baseContext,
                "Sign in failed, check your credentials!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    companion object {
        private const val TAG = "SignIn"
    }
}
