package com.example.recyclerview

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private var data: ArrayList<String>) :
    RecyclerView.Adapter<UserAdapter.UserHolder>() {

    private var lastIndex = -1

    inner class UserHolder(private var view: View) : RecyclerView.ViewHolder(view) {

        private var title: TextView = view.findViewById(R.id.title)
        private var img: ImageView = view.findViewById(R.id.img)

        @SuppressLint("SetTextI18n")
        fun bind(text: String) {
            title.text = text
            img.visibility = View.GONE
            view.setOnClickListener {
                if (lastIndex != -1){
                    notifyItemChanged(lastIndex)
                }
                title.text = "${title.text} $lastIndex"
                img.visibility = View.VISIBLE
                lastIndex = adapterPosition
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder =
        UserHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}