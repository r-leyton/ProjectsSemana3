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
        val numero1 = findViewById<EditText>(R.id.etValor1)
        val numero2 = findViewById<EditText>(R.id.etValor2)
        val numero3 = findViewById<EditText>(R.id.etValor3)
        val btnSuma = findViewById<Button>(R.id.btnSumar)
        val btnResta = findViewById<Button>(R.id.btnRestar)
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val btnDividir = findViewById<Button>(R.id.btnDividir)
        val resultado = findViewById<TextView>(R.id.etResultado)

        btnSuma.setOnClickListener{
            val a = numero1.text.toString().trim()
            val b = numero2.text.toString().trim()
            val c = numero3.text.toString().trim()

            if (a.isNotEmpty()&& b.isNotEmpty() && c.isNotEmpty()){
                val res = a.toDouble() + b.toDouble() + c.toDouble()
                resultado.text = "Resultado: $res"
            }else{
                resultado.text = "Los datos no son corectos"
            }

        }
        btnResta.setOnClickListener{
            val a = numero1.text.toString().trim()
            val b = numero2.text.toString().trim()
            val c = numero3.text.toString().trim()
            if (a.isNotEmpty()&& b.isNotEmpty() && c.isNotEmpty()){
                val res = a.toDouble() - b.toDouble() - c.toDouble()
                resultado.text = "Resultado: $res"
            }else{
                resultado.text = "Los datos no son corectos"
            }

        }
        btnMultiplicar.setOnClickListener{
            val a = numero1.text.toString().trim()
            val b = numero2.text.toString().trim()
            val c = numero3.text.toString().trim()
            if (a.isNotEmpty()&& b.isNotEmpty() && c.isNotEmpty()){
                val res = a.toDouble() * b.toDouble() * c.toDouble()
                resultado.text = "Resultado: $res"
            }else{
                resultado.text = "Los datos no son corectos"
            }

        }
        btnDividir.setOnClickListener{
            val a = numero1.text.toString().trim()
            val b = numero2.text.toString().trim()
            val c = numero3.text.toString().trim()
            if (a.isNotEmpty()&& b.isNotEmpty() && c.isNotEmpty()){
                val divisor2 = b.toDouble()
                val divisor3 = c.toDouble()
                if (divisor2 != 0.0 && divisor3 != 0.0) {
                    val res =a.toDouble() / divisor2 / divisor3
                    resultado.text = "Resultado: $res"
                } else {
                    resultado.text = "No se puede dividir entre 0"
                }
            }else{
                resultado.text = "Los datos no son corectos"
            }



        }
        
    }

}
