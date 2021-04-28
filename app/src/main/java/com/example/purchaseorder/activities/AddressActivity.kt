package com.example.purchaseorder.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.purchaseorder.R
import com.example.purchaseorder.adapters.AdapterShippingDetails
import com.example.purchaseorder.models.Address
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_address.*

class AddressActivity : AppCompatActivity() {

    lateinit var adapterShippingDetails: AdapterShippingDetails

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        init()
    }

    private fun init() {
        getData()
        adapterShippingDetails = AdapterShippingDetails(this)
        recycler_view.adapter = adapterShippingDetails
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    private fun getData() {
        var requestQueue = Volley.newRequestQueue(this)
        //I need to access api address dynamically
        var request = StringRequest(
            Request.Method.GET,
            "http://grocery-second-app.herokuapp.com/api/address/603c691772642f00171f30c2",
            {
                var gson = Gson()
                var address = gson.fromJson(it,Address::class.java)

                adapterShippingDetails.setData(address.data)

            },
            {
                Toast.makeText(applicationContext,it.message,Toast.LENGTH_SHORT).show()
                Log.d("abc",it.message.toString())
            }
        )

        requestQueue.add(request)

    }
}