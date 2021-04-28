package com.example.purchaseorder.app

class Endpoints {

    companion object{

        //"http://grocery-second-app.herokuapp.com/api/address/603c691772642f00171f30c2"
        private const val URL_ADDRESS = "address/"


        fun getAddress(): String {
            return "${Config.BASE_URL + URL_ADDRESS}603c691772642f00171f30c2"
        }

        fun createAddress(): String{
            return "${Config.BASE_URL + URL_ADDRESS}"
        }

    }

}