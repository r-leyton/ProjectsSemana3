package com.example.projectssemana3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast
import java.text.SimpleDateFormat;
import java.util.*





class MainActivity : AppCompatActivity() {

    data class Asistencia(
        val codigo: String,
        val nombre: String,
        val fecha: String,
        val hora: String
    )

    private lateinit var listaAsistencias: MutableList<Asistencia>
    private lateinit var adaptador: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val edtCodigo = findViewById<EditText>(R.id.edtCodigo)
        val edtNombre = findViewById<EditText>(R.id.edtNombre)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val listView = findViewById<ListView>(R.id.listViewAsistencias)

        listaAsistencias = mutableListOf()
        adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableListOf())
        listView.adapter = adaptador

        btnRegistrar.setOnClickListener {
            val codigo = edtCodigo.text.toString()
            val nombre = edtNombre.text.toString()

            if (codigo.isNotEmpty() && nombre.isNotEmpty()) {
                val fechaActual = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
                val horaActual = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())

                val asistencia = Asistencia(codigo, nombre, fechaActual, horaActual)
                listaAsistencias.add(asistencia)

                // Mostrar en el ListView
                val texto = "Código: ${asistencia.codigo}\nNombre: ${asistencia.nombre}\nFecha: ${asistencia.fecha} - Hora: ${asistencia.hora}"
                adaptador.add(texto)
                adaptador.notifyDataSetChanged()

                // Limpiar campos
                edtCodigo.text.clear()
                edtNombre.text.clear()
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}