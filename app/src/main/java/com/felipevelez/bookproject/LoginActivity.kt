package com.felipevelez.bookproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.felipevelez.bookproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        var emailReceived : String? = ""
        var passwordReceived : String? = ""
        val credentials =intent.extras

        if(credentials!= null){
            emailReceived = credentials.getString("email")
            passwordReceived = credentials.getString("password")
        }

        loginBinding.registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        with(loginBinding){
            signInButton.setOnClickListener {
                val  email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()

                if(email ==emailReceived && password == passwordReceived && email.isNotEmpty() && password.isNotEmpty()){
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }else{
                    Toast.makeText(applicationContext,"El usuario ó la contraseña son incorrectas",Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this,"Hasta Pronto",Toast.LENGTH_SHORT).show()
    }
}