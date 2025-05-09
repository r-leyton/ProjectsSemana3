package com.example.projectssemana3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val txtUsuario = findViewById<EditText>(R.id.etUsuario)
        val txtContrasena = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val lblResultado = findViewById<TextView>(R.id.tvResultado)

        btnLogin.setOnClickListener {
            val usuario = txtUsuario.text.toString()
            val contrasena = txtContrasena.text.toString()

            if (usuario == "admin" && contrasena == "1234") {
                lblResultado.text = "Inicio de sesión correcto"
            } else {
                lblResultado.text = "Usuario o contraseña incorrectos"
            }
        }
    }
}