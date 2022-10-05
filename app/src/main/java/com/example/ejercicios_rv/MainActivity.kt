package com.example.ejercicios_rv

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejercicios_rv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val listaContactos = listOf<Contacto>(
        Contacto("https://loremflickr.com/320/240?lock=1","Juan","Juan@ejemplo.com","999000111"),
        Contacto("https://loremflickr.com/320/240?lock=2", "Pepe","Pe_pe@ejemplo.com","686993321"),
        Contacto("https://loremflickr.com/320/240?lock=3","Diego","diego@ejemplo.com","666000555")
    )
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Creamos el binding
        val binding =ActivityMainBinding.inflate(layoutInflater)
    with(binding)
    {
        setContentView(root)
        recycler.adapter = ContactosAdapter(listaContactos
        ) {
        val intent = Intent(this@MainActivity,DetailActivity::class.java)
           intent.putExtra(DetailActivity.EXTRA_CONTACTO,it)
            startActivity(intent)
        }
    }


    }
}

