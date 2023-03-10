package com.example.authenication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        // ...
        // Initialize Firebase Auth
        auth = Firebase.auth
    }
    fun toregister (view: View){
        val email = findViewById<EditText>(R.id.etemail)
        val password = findViewById<EditText>(R.id.etpwd)

        auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString()).addOnCompleteListener {
            task ->
            if (task.isSuccessful){
                val i = Intent(this,Login::class.java)
                startActivity(i)
                finish()
            }
        }.addOnFailureListener {exception ->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }
    }

    fun gotologin (view: View){
        val i = Intent(this,Login::class.java)
        startActivity(i)
    }
}