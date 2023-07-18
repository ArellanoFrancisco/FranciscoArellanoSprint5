package com.example.shoestap.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.shoestap.R
import com.example.shoestap.databinding.Fragment2Binding
import com.example.shoestap.modelo.CartItem
import com.example.shoestap.modelo.CartList
import com.example.shoestap.modelo.Preferencias



class Fragment2 : Fragment() {

    private lateinit var binding: Fragment2Binding
    private lateinit var shoeName: String
    private lateinit var shoeImage: String
    private var shoePrice: Double = 0.0
    private var shoeCantidad: Int = 1
    private var currentQuantity = 1
    private lateinit var cartList: CartList
    private lateinit var preferences: Preferencias

    private fun updatePrice() {
        binding.precio2.text = ((shoePrice ?: 0.0) * currentQuantity).toString()
    }

    private fun increaseQuantity() {
        currentQuantity++
        binding.cantidad.text = currentQuantity.toString()
        updatePrice()
    }

    private fun decreaseQuantity() {
        if (currentQuantity > 1) {
            currentQuantity--
            binding.cantidad.text = currentQuantity.toString()
            updatePrice()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater, container, false)

        arguments?.let { bundle ->
            shoeName = bundle.getString("name").toString()
            shoeImage = bundle.getString("imageUrl").toString()
            shoePrice = bundle.getDouble("price")
            shoeCantidad = bundle.getInt("cantidad")

        }
        preferences = Preferencias(requireContext())
        cartList = preferences.getCartList()

        binding.name2.text = shoeName
        Glide.with(requireContext()).load(shoeImage).into(binding.image2)
        binding.precio2.text = shoePrice.toString()
        binding.cantidad.text = shoeCantidad.toString()

        binding.add1.setOnClickListener {
            increaseQuantity()
        }

        binding.remove2.setOnClickListener {
            decreaseQuantity()
        }
        binding.add2.setOnClickListener {
            // Guardar los datos en SharedPreferences
            val cartItem = CartItem(shoeName, shoeImage, shoePrice, currentQuantity)
            cartList.agregarItem(cartItem)
            preferences.guardarCartList(cartList)


            // Navegar a Fragment3
            findNavController().navigate(R.id.action_fragment2_to_fragment3)

        }
        binding.back2.setOnClickListener {
            findNavController().navigate(R.id.action_fragment2_to_fragment1)
        }

        return binding.root
    }

}