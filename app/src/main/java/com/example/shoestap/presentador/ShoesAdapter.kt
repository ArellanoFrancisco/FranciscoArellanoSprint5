package com.example.shoestap.presentador

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoestap.R
import com.example.shoestap.modelo.Shoe

class ShoesAdapter(private val Shoelist:List<Shoe>, private val shoeInterface: ShoeInterface) : RecyclerView.Adapter<ShoesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoesViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.shoes, parent, false)
        return ShoesViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int = Shoelist.size

    override fun onBindViewHolder(holder: ShoesViewHolder, position: Int) {
        val item = Shoelist[position]
        holder.show(item)
        holder.itemView.setOnClickListener {
            shoeInterface.onItemClick(item)
        }

    }
}