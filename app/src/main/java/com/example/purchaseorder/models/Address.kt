package com.example.purchaseorder.models

data class Address(
    val count: Int,
    val data: ArrayList<Data>,
    val error: Boolean
)

data class Data(
    val __v: Int,
    val _id: String,
    val city: String,
    val houseNo: String,
    val pincode: Int,
    val streetName: String,
    val type: String,
    val userId: String
)