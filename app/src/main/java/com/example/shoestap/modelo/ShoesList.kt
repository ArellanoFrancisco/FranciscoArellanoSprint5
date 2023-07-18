package com.example.shoestap.modelo

open class ShoesList {

    fun returnShoeList(): List<Shoe> {
        val ShoeList = mutableListOf<Shoe>()
        val shoeItem1 = Shoe(
            "ZAPATILLAS NIKE DUNK HIGH PANDA",
            "https://leaked.cl/store/15237-large_default/zapatillas-nike-dunk-high-panda.jpg",
            169.990,
            1
        )
        ShoeList.add(shoeItem1)
        val shoeItem2 = Shoe(
            "ZAPATILLAS TENSAUR SPORT TRAINING CIERRE DE CORDONES",
            "https://assets.adidas.com/images/w_600,f_auto,q_auto/aa53a0a800c846abb44aae8a00367e1d_9366/Zapatillas_Tensaur_Sport_Training_Cierre_de_Cordones_Blanco_GW6422_01_standard.jpg",
            44.990, 1
        )
        ShoeList.add(shoeItem2)
        val shoeItem3 = Shoe(
            "ZAPATILLAS ADIDAS GRAND COURT TD",
            "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/78b76ab3632d4251a7f2ae2b005fb600_9366/Zapatillas_adidas_Grand_Court_TD_Blanco_GW9250_01_standard.jpg",
            49.990, 1
        )
        ShoeList.add(shoeItem3)
        val shoeItem4 = Shoe(
            "Zapatilla ADIDAS Urbana Design Grand Court 2.0 Mujer",
            "https://www.paris.cl/dw/image/v2/BCHW_PRD/on/demandware.static/-/Sites-cencosud-master-catalog/default/dw6e06f4aa/images/imagenes-productos/667/142494-0100-001.jpg?sw=513&sh=654&sm=fit",
            40.790, 1
        )
        ShoeList.add(shoeItem4)
        val shoeItem5 = Shoe(
            "ZAPATILLAS DC COURT GRAFFIK DE HOMBRE",
            "https://www.dcshoes.cl/media/catalog/product/3/0/300529_dcwlk_1_1_1_10.jpg?optimize=medium&bg-color=255,255,255&fit=bounds&height=560&width=700&canvas=700:560",
            69.990, 1
        )
        ShoeList.add(shoeItem5)
        val shoeItem6 = Shoe(
            "Zapatillas De Lona Con Caña Alta Unisex",
            "https://falabella.scene7.com/is/image/Falabella/gsc_116104261_1371478_3?wid=1500&hei=1500&qlt=70",
            19.990, 1
        )
        ShoeList.add(shoeItem6)
        val shoeItem7 = Shoe(
            "ZAPATILLAS Air Jordan 1 Low",
            "https://nikeclprod.vteximg.com.br/arquivos/ids/637235-1000-1000/553558_412_A_PREM-hei-3144-wid-3144-fmt.jpg?v=638078760608270000",
            89.990, 1
        )
        ShoeList.add(shoeItem7)
        val shoeItem8 = Shoe(
            "Zapatilla CONVERSE Urbana con Caña Chuck Taylor All Star Unisex",
            "https://www.paris.cl/dw/image/v2/BCHW_PRD/on/demandware.static/-/Sites-cencosud-master-catalog/default/dw1e94a282/images/imagenes-productos/667/711777-0001-001.jpg?sw=513&sh=654&sm=fit",
            54.990, 1
        )
        ShoeList.add(shoeItem8)
        val shoeItem9 = Shoe(
            "Zapatilla Deportiva W Revolution 6 NN Morado Nike",
            "https://static.dafiti.cl/p/nike-4624-7524161-1-product.jpg",
            64.990, 1
        )
        ShoeList.add(shoeItem9)
        val shoeItem10 = Shoe(
            "ZAPATILLAS JORDAN 1 MID REVERSE CHICAGO MUJER",
            "https://leaked.cl/store/10732-large_default/zapatillas-jordan-1-mid-reverse-chicago-mujer.jpg",
            139.990, 1
        )
        ShoeList.add(shoeItem10)
        return ShoeList
    }
}
