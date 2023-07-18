package com.example.shoestap.modelo

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class Preferencias(context: Context) {
    private companion object {
        const val SHARED_PREFERENCES_NAME = "ShoesTap"
        const val KEY_CART_LIST = "CartList"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    fun guardarCartList(cartList: CartList) {
        val editor = sharedPreferences.edit()
        editor.putString(KEY_CART_LIST, Gson().toJson(cartList))
        editor.apply()
    }

    fun getCartList(): CartList {
        val jsonString = sharedPreferences.getString(KEY_CART_LIST, "")
        return if (jsonString.isNullOrEmpty()) {
            CartList()
        } else {
            Gson().fromJson(jsonString, CartList::class.java)
        }
    }
    fun borrarTodoCartList() {
        val editor = sharedPreferences.edit()
        editor.remove(KEY_CART_LIST)
        editor.apply()
    }
}