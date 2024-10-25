package com.example.actud2_212_aocheng_ye

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class CustomAdapter (private val context: Context, private val items: List<Item>) :BaseAdapter(){
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Item {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val item = getItem(position)

        holder.imageView.setImageResource(item.imageResId)
        holder.textViewTitle.text = item.title
        holder.textViewDescription.text = item.description
        holder.buttonRadio.isChecked = item.check


        holder.imageView.setOnClickListener {
            val texto = holder.textViewDescription.text
            Toast.makeText(context, texto, Toast.LENGTH_LONG).show()
        }

        holder.buttonRadio.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
            val bool = holder.buttonRadio.isChecked
            Toast.makeText(context, "Botón clicado en posición: $position", Toast.LENGTH_LONG)
                .show()

        }
        return view
    }

    private class ViewHolder(view: View) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val textViewTitle: TextView = view.findViewById(R.id.textViewTitle)
        val textViewDescription: TextView = view.findViewById(R.id.textViewDescription)
        val buttonRadio: RadioButton = view.findViewById(R.id.radioButton)
    }
    }
