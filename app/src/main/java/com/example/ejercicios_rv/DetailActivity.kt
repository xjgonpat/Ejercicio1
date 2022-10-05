package com.example.ejercicios_rv

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.ejercicios_rv.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    companion object
    {
        const val EXTRA_CONTACTO = "Contacto"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val contacto = intent?.getParcelableExtra<Contacto>(EXTRA_CONTACTO) ?: throw IllegalStateException()

        binding.tvNombreDetail.text= contacto.nombre
        Glide.with(binding.root.context)
            .load(contacto.foto)
            .into(binding.imageView2)

        //En el evento del botón de llamar enseñamos un toast
        binding.btnLlamar.setOnClickListener()
        {
            Toast.makeText(binding.root.context,"Llamando a ${contacto.telefono}",Toast.LENGTH_SHORT).show()
        }

        //En el evento del botón del email enseñamos un toast
        binding.btnEmail.setOnClickListener()
        {
            Toast.makeText(binding.root.context,"Enviando un correo a ${contacto.correo}",Toast.LENGTH_SHORT).show()
        }

    }
}