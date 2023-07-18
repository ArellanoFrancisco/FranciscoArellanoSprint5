package com.example.shoestap.vista


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoestap.R
import com.example.shoestap.databinding.Fragment3Binding
import com.example.shoestap.modelo.CartList
import com.example.shoestap.modelo.Preferencias
import com.example.shoestap.presentador.CartAdapter
import com.example.shoestap.presentador.CartInterface

class Fragment3 : Fragment(), CartInterface {

    private lateinit var binding: Fragment3Binding
    private lateinit var preferences: Preferencias
    private lateinit var cartList: CartList
    private lateinit var cartAdapter: CartAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment3Binding.inflate(inflater, container, false)

        preferences = Preferencias(requireContext())
        cartList = preferences.getCartList()


        // Configuramos el RecyclerView y el Adapter
        cartAdapter = CartAdapter(cartList.obtenerItems().toMutableList())
        cartAdapter.cartInterface = this
        binding.RV2.layoutManager = LinearLayoutManager(requireContext())
        binding.RV2.adapter = cartAdapter

        updateTotalPrice()

        binding.back2.setOnClickListener {
            findNavController().navigate(R.id.action_fragment3_to_fragment1)
        }
        binding.deleteall.setOnClickListener {
            // vaciamos el carrito
            preferences.borrarTodoCartList()
            cartList = CartList()
            cartAdapter.actualizarLista(cartList.obtenerItems())
            updateTotalPrice()
        }
        binding.checkout.setOnClickListener {
            //vaciamos el carrito
            preferences.borrarTodoCartList()
            cartList = CartList()
            cartAdapter.actualizarLista(cartList.obtenerItems())
            updateTotalPrice()
            // Mostramos un Toast
            Toast.makeText(requireContext(), R.string.compra, Toast.LENGTH_LONG).show()
            // Cerrar la app después de 3 segundos
            Handler().postDelayed({
                activity?.finish()
            }, 3000)
        }

        return binding.root
    }

    override fun onItemDeleteClick(itemName: String) {
        // borrar item individual
        cartList.borrarItemPorNombre(itemName)
        preferences.guardarCartList(cartList)
        cartAdapter.actualizarLista(cartList.obtenerItems())
        updateTotalPrice()
    }

    private fun updateTotalPrice() {
        // actualizar precio en el monto final
        val total = cartList.obtenerItems().sumOf { it.getTotalPrice() }
        binding.totalprice.text = getString(R.string.totalprice, total)
    }
}


