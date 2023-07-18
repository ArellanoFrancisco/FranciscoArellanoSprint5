package com.example.shoestap.modelo



class CartList {

    private val list: MutableList<CartItem> = mutableListOf()

    fun obtenerItems(): MutableList<CartItem> {
        return list
    }

    fun agregarItem(cartItem: CartItem) {
        list.add(cartItem)
    }

    fun borrarItemPorNombre(nombre: String) {
        list.removeAll { it.name == nombre }
    }

}