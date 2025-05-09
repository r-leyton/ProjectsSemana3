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
        val valor1 = findViewById<EditText>(R.id.valor1)
        val valor2 = findViewById<EditText>(R.id.valor2)
        val valor3 = findViewById<EditText>(R.id.valor3)
        val valor4 = findViewById<EditText>(R.id.valor4)
        val valor5 = findViewById<EditText>(R.id.valor5)
        val btnOrdenar = findViewById<Button>(R.id.btnOrdenar)
        val result = findViewById<TextView>(R.id.resultado)

        btnOrdenar.setOnClickListener{
            val a = valor1.text.toString().trim()
            val b = valor2.text.toString().trim()
            val c = valor3.text.toString().trim()
            val d = valor4.text.toString().trim()
            val e = valor5.text.toString().trim()

            if (a.isNotEmpty() && b.isNotEmpty()&& c.isNotEmpty() && d.isNotEmpty() && e.isNotEmpty()){
                val valores = doubleArrayOf( a.toDouble(),b.toDouble(),c.toDouble(),d.toDouble(),e.toDouble())
                val ordenados = burbuja(valores)
                result.text = "Ordenado: ${ordenados.joinToString(", ")}"
            }


        }
    }
    public fun burbuja( arr:DoubleArray):DoubleArray{
        val n = arr.size
        for (i in 0 until n - 1) {
            for (j in 0 until n - i - 1) {
                if (arr[j] > arr[j + 1]) {
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                }
            }
        }
        return arr
    }
}
