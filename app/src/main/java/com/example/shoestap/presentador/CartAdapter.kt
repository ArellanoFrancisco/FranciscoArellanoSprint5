package com.example.shoestap.presentador

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoestap.R
import com.example.shoestap.modelo.CartItem
import com.example.shoestap.presentado.CartViewHolder



class CartAdapter(val cartList: MutableList<CartItem>) : RecyclerView.Adapter<CartViewHolder>() {
    var cartInterface: CartInterface? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart, parent, false)
        val viewHolder = CartViewHolder(view, this)
        return viewHolder
    }
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartList[position]
        holder.show2(item)
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    fun actualizarLista(nuevaLista: List<CartItem>) {
        cartList.clear()
        cartList.addAll(nuevaLista)
        notifyDataSetChanged()
    }


}