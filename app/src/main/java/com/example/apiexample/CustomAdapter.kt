package com.example.apiexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(var list: PostComment?) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val postId: TextView = itemview.findViewById(R.id.postId)
        val id: TextView = itemview.findViewById(R.id.id)
        val name: TextView = itemview.findViewById(R.id.name)
        val email: TextView = itemview.findViewById(R.id.email)
        val body: TextView = itemview.findViewById(R.id.body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycle, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postId.text= list!![position].postId.toString()
        holder.id.text= list!![position].id.toString()
        holder.name.text= list!![position].name
        holder.email.text= list!![position].email
        holder.body.text= list!![position].body
    }

}