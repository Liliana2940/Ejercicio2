package com.example.ejercicio2.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicio2.databinding.HpElementBinding
import com.example.ejercicio2.model.HP

class HPAdapter(private var context: Context, private var hp:ArrayList<HP>): RecyclerView.Adapter<HPAdapter.ViewHolder> (){

    class ViewHolder(view:HpElementBinding):RecyclerView.ViewHolder(view.root) {
        val ivThumnail = view.ivThumbnail
        val tvReleased = view.tvReleased
        val tvTitle = view.tvTitle
        val tvDeveloper = view.tvDeveloper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = HpElementBinding.inflate(LayoutInflater.from(context))
            return  ViewHolder(binding)
         }

    override fun getItemCount(): Int = hp.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = hp[position].name
        holder.tvDeveloper.text =hp[position].actor
        holder.tvReleased.text = hp[position].house
        Glide.with(context)
            .load(hp[position].image)
            .into(holder.ivThumnail)

        holder.itemView.setOnClickListener {

        }
    }


}