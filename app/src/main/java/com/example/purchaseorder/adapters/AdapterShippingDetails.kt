package com.example.purchaseorder.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.purchaseorder.R
import com.example.purchaseorder.models.Address
import com.example.purchaseorder.models.Data
import kotlinx.android.synthetic.main.shipping_detail_adapter.view.*

class AdapterShippingDetails(var mContext: Context):RecyclerView.Adapter<AdapterShippingDetails.ViewHolder>(){

    var mList: ArrayList<Data> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.activity_address,parent,false)

        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = mList[position]

        holder.bind(data)
    }

    fun setData(list: ArrayList<Data>){
        mList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(address: Data){
            itemView.text_view_houseNo.text = address.houseNo
            itemView.text_view_streetName.text = address.streetName
            itemView.text_view_city.text = address.city

        }
    }
}