package com.example.purchaseorder.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.purchaseorder.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        button_order.setOnClickListener {
            var intent = Intent(this,AddressActivity::class.java)

            startActivity(intent)
        }

    }
}