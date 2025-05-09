package com.example.projectssemana3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var listaAlumnos: ArrayList<String>
    private lateinit var adaptador: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val txtCodigo = findViewById<EditText>(R.id.etCodigo)
        val txtNombre = findViewById<EditText>(R.id.etNombre)
        val txtCorreo = findViewById<EditText>(R.id.etCorreo)
        val txtDireccion = findViewById<EditText>(R.id.etDireccion)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val listView = findViewById<ListView>(R.id.listViewAlumnos)

        listaAlumnos = ArrayList()
        adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAlumnos)
        listView.adapter = adaptador
        btnRegistrar.setOnClickListener{
            val codigo = txtCodigo.text.toString()
            val nombre = txtNombre.text.toString()
            val correo = txtCorreo.text.toString()
            val direction = txtDireccion.text.toString()

            if (codigo.isNotEmpty() && nombre.isNotEmpty() && correo.isNotEmpty() && direction.isNotEmpty()){
                val alumno = "Código: $codigo\nNombre: $nombre\nCorreo: $correo\nDirección: $direction"
                listaAlumnos.add(alumno)
                adaptador.notifyDataSetChanged()

                txtCodigo.text.clear()
                txtNombre.text.clear()
                txtCorreo.text.clear()
                txtDireccion.text.clear()
            }else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}