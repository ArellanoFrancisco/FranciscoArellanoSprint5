package com.example.shoestap.presentado

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoestap.databinding.CartBinding
import com.example.shoestap.modelo.CartItem
import com.example.shoestap.presentador.CartAdapter
import com.example.shoestap.presentador.CartInterface

class CartViewHolder(view: View, private val adapter: CartAdapter) : RecyclerView.ViewHolder(view),
    CartInterface {
    val binding = CartBinding.bind(view)


    fun show2(cartItem: CartItem) {
        binding.nameShoe.text = cartItem.name
        binding.priceShoe.text = cartItem.getTotalPrice().toString()
        Glide.with(binding.imageCart.context).load(cartItem.imageUrl)
            .into(binding.imageCart)
        binding.CantidadCart.text = cartItem.quantity.toString()
    }

    override fun onItemDeleteClick(itemName: String) {
        adapter.cartInterface?.onItemDeleteClick(itemName)
    }

    init {
        binding.quitarCart.setOnClickListener {
            val itemName = adapter.cartList[adapterPosition].name
            adapter.cartInterface?.onItemDeleteClick(itemName)
        }
    }
}
