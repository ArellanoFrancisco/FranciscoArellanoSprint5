package com.example.shoestap.presentador

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoestap.databinding.ShoesBinding
import com.example.shoestap.modelo.Shoe

class ShoesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val binding = ShoesBinding.bind(view)

    fun show(shoe: Shoe){
        binding.nameShoe.text = shoe.name
        binding.priceShoe.text = shoe.price.toString()
        Glide.with(binding.imageShoe.context).load(shoe.imageUrl).into(binding.imageShoe)

    }


}