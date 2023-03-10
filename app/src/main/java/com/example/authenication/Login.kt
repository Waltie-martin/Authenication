package com.example.authenication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // ...
        // Initialize Firebase Auth
        auth = Firebase.auth
    }
    fun tologin(view: View){
        val emailet = findViewById<EditText>(R.id.etemail1)
        val login = findViewById<EditText>(R.id.etpwd2)

        if (TextUtils.isEmpty(emailet.text.toString()) || TextUtils.isEmpty(login.text.toString())){
            Toast.makeText(this,"Please fill all the fields",Toast.LENGTH_LONG).show()
        }else{
            auth.signInWithEmailAndPassword(emailet.text.toString(),login.text.toString()).addOnCompleteListener{task ->
                if(task.isSuccessful){
                    val i  = Intent(this,MainActivity::class.java)
                    startActivity(i)
                    finish()
                }else{
                    Toast.makeText(this,"Please enter correct Credentials", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    fun Forgot(view: View){
        val y = Intent(this,Forgotit::class.java)
        startActivity(y)
    }

    fun toRegister(view: View){
        val i = Intent(this,Register::class.java)
        startActivity(i)
    }
}