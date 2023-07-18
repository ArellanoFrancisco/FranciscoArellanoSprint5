package com.example.shoestap.modelo

data class CartItem(val name: String, val imageUrl: String, val price: Double, val quantity: Int){
    fun getTotalPrice(): Double {
        return price * quantity
    }
}
