package com.shivam.boat.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.shivam.boat.Model
import com.shivam.boat.R
import com.shivam.boat.UserDetail

class RecyclerViewAdapter(val lists: MutableList<Model>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater:LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            var intent = Intent(holder.itemView.context,UserDetail::class.java )
            intent.putExtra("pos",position)
            holder.itemView.context.startActivity(intent)
        }
        return holder.bindView(lists.get(position))
    }

    override fun getItemCount(): Int {
       return lists.size
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var txtTitle = itemView.findViewById<TextView>(R.id.txtName)
    var txtDesc = itemView.findViewById<TextView>(R.id.companyName)

    fun bindView(lists: Model){
        txtTitle.text = lists.name
        txtDesc.text = "Company : " + lists.company.name


    }

}