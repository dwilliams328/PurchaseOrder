package com.example.purchaseorder.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.purchaseorder.R
import com.example.purchaseorder.adapters.AdapterShippingDetails
import com.example.purchaseorder.app.Endpoints
import com.example.purchaseorder.models.Data
import kotlinx.android.synthetic.main.activity_add_address.*
import kotlinx.android.synthetic.main.activity_address.*
import org.json.JSONObject

class AddAddressActivity : AppCompatActivity() {

    var mList: ArrayList<Data> = ArrayList()
    lateinit var adapterShippingDetails: AdapterShippingDetails

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_address)

        init()
    }

    private fun init() {
        button_submit.setOnClickListener {
            var pinCode = edit_text_pinCode.text.toString().toInt()
            var city = edit_text_city.toString()
            var streetName = edit_text_streetName.text.toString()
            var houseNo = edit_text_houseNo.text.toString()
            var type = edit_text_type.text.toString()
            var userID = edit_text_userID.text.toString()

            var jsonObject = JSONObject()

            jsonObject.put("pincode", pinCode)
            jsonObject.put("city", city)
            jsonObject.put("streetName", streetName)
            jsonObject.put("houseNo", houseNo)
            jsonObject.put("type", type)
            jsonObject.put("userId", userID)

            var requestQueue = Volley.newRequestQueue(this)

            var jsonRequest = JsonObjectRequest(
                Request.Method.POST,
                Endpoints.getAddress(),
                jsonObject,
                {
                    Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_SHORT).show()
                    Log.d("abc", it.toString())

                },
                {
                        Log.d("abc", it.message.toString())
//                    Toast.makeText(applicationContext, it.stackTrace.toString(), Toast.LENGTH_SHORT).show()
//                    Toast.makeText(applicationContext, it.localizedMessage.toString(), Toast.LENGTH_SHORT).show()
                }
            )

            requestQueue.add(jsonRequest)

            var intent = Intent(this,AddressActivity::class.java)

            startActivity(intent)
        }
    }
}