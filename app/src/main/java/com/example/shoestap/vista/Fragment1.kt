package com.example.shoestap.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoestap.R
import com.example.shoestap.databinding.Fragment1Binding
import com.example.shoestap.modelo.Shoe
import com.example.shoestap.modelo.ShoesList
import com.example.shoestap.presentador.ShoeInterface
import com.example.shoestap.presentador.ShoesAdapter


open class Fragment1 : Fragment(), ShoeInterface {

    lateinit var binding: Fragment1Binding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater, container, false)
        initRecyclerview()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.carrito1.setOnClickListener {
            findNavController().navigate(R.id.action_fragment1_to_fragment3)
        }
    }
    fun initRecyclerview(){

        binding.RV1.layoutManager = LinearLayoutManager(this.context)
        val shoesAdapter = ShoesAdapter(ShoesList().returnShoeList(), this)
        binding.RV1.adapter = shoesAdapter
    }

    override fun onItemClick(shoe: Shoe) {
        val bundle = Bundle().apply {
            putString("name", shoe.name)
            putString("imageUrl", shoe.imageUrl)
            putDouble("price", shoe.price)
            putInt("cantidad", shoe.cantidad)
        }
        findNavController().navigate(R.id.action_fragment1_to_fragment2, bundle)
    }
}