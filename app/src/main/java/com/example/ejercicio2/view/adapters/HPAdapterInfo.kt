package com.example.ejercicio2.view.adapters

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicio2.databinding.HpElementBinding
import com.example.ejercicio2.model.HPDetail

class HPAdapterInfo(private var context: Context, private var hp1:ArrayList<HPDetail>, private val clickListener: (HPDetail)-> Unit): RecyclerView.Adapter<HPAdapterInfo.ViewHolder> (){

    class ViewHolder(view: HpElementBinding): RecyclerView.ViewHolder(view.root) {
        val ivThumnail = view.ivThumbnail
        val tvReleased = view.tvReleased
        val tvTitle = view.tvTitle
        val tvDeveloper = view.tvDeveloper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }


    override fun getItemCount(): Int = hp1.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = hp1[position].name
        holder.tvDeveloper.text =hp1[position].actor
        holder.tvReleased.text = hp1[position].house

        Glide.with(context)
            .load(hp1[position].image)
            .into(holder.ivThumnail)

        holder.itemView.setOnClickListener {
            clickListener(hp1[position])
        }
    }


}