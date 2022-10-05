package com.example.ejercicios_rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicios_rv.databinding.ContactoItemBinding

class ContactosAdapter(
    private val contactos:List<Contacto>,
    val contactoClickListener: (Contacto)->Unit):
    RecyclerView.Adapter<ContactosAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Creamos un binding para pasarselo al viewHolder como parámetro.
        val binding = ContactoItemBinding.inflate(LayoutInflater
                .from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contacto = contactos[position]
        holder.bind(contacto)

        //Utilizamos la función lambda recibida como parámetro.
        holder.itemView.setOnClickListener{
            contactoClickListener(contacto)
        }
    }

    override fun getItemCount(): Int = contactos.size

    class ViewHolder(val binding : ContactoItemBinding):RecyclerView.ViewHolder(binding.root)
    {
        fun bind(contact:Contacto)
        {
            //Insertamos la imagen con Glide usando el contexto de binding.root
            Glide.with(binding.root.context)
                .load(contact.foto)
                .into(binding.imagen)
            binding.tvNombre.text=contact.nombre
            binding.tvTelef.text=contact.telefono
            binding.tvEmail.text=contact.correo

        }
    }
}