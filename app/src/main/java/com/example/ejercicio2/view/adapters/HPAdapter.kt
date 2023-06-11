package com.example.ejercicio2.view.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicio2.databinding.ActivityMainBinding
import com.example.ejercicio2.databinding.HpElementBinding
import com.example.ejercicio2.model.HP

class HPAdapter(private var context: Context, private var hp:ArrayList<HP>, private val studentVal: Boolean?, private val clickListener: (HP)-> Unit): RecyclerView.Adapter<HPAdapter.ViewHolder> (){
    //private var studentVal: String? = null
    class ViewHolder(view:HpElementBinding):RecyclerView.ViewHolder(view.root) {
        val ivThumnail = view.ivThumbnail
        val tvReleased = view.tvReleased
        val tvTitle = view.tvTitle
        val tvDeveloper = view.tvDeveloper
        val tvStudent = view.tvEstudiante
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = HpElementBinding.inflate(LayoutInflater.from(context))
            return  ViewHolder(binding)

         }
    class HPAdapter : AppCompatActivity() {
        private lateinit var binding: ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val bundle = intent.extras
            // studentVal = bundle?.getString("student", "")


        }}
    override fun getItemCount(): Int = hp.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvStudent.freezesText= hp[position].student == true
        var student= holder.tvStudent.freezesText  //el valor de la lista de caracteres dice si es falso o verdadero ser estudiante

      //  studentVal el valor del menu, que seran si todos estudiante o personal
        if(studentVal==true) {
            if(student==studentVal){
          //  holder.tvTitle.text = hp[position].name
           // holder.tvDeveloper.text = hp[position].actor
            holder.tvReleased.text = hp[position].house

            Glide.with(context)
                .load(hp[position].image)
                .into(holder.ivThumnail)

            holder.itemView.setOnClickListener {
                clickListener(hp[position])
            }
            }}
            //else if(studentVal==false) {
                if (student == studentVal) {
                    holder.tvTitle.text = hp[position].name
                    holder.tvDeveloper.text = hp[position].actor
                    holder.tvReleased.text = hp[position].house

                    // Glide.with(context)
                    //   .load(hp[position].image)
                    // .into(holder.ivThumnail)

                    holder.itemView.setOnClickListener {
                        clickListener(hp[position])
                    }
                }

            //}

    }}


