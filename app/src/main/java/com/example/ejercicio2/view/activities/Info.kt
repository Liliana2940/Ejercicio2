package com.example.ejercicio2.view.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.ejercicio2.databinding.ActivityInfoBinding
import com.example.ejercicio2.model.HP
import com.example.ejercicio2.network.HPApi
import com.example.ejercicio2.network.RetrofitService
import com.example.ejercicio2.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Info : AppCompatActivity() {

    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        val id = bundle?.getString("id", "")
        //val id1= id
        //val call = RetrofitService.getRetrofit().create(HPApi::class.java)
          //  .getHPDetail(id)             //Con Apiary
        val call = RetrofitService.getRetrofit().create(HPApi::class.java)
            .getHP("character/"+id)  //Con Apiary
        //.getGameDetail(id) //Para el servidor www.serverbpw.com


        call.enqueue(object: Callback<ArrayList<HP>>{
            override fun onResponse(call: Call<ArrayList<HP>>, response: Response<ArrayList<HP>>) {
                binding.pbConexion.visibility = View.GONE
                Log.d(Constants.LOGTAG, "Respuesta del servidor: ${response.toString()}")
                Log.d(Constants.LOGTAG, "Datos: ${response.body().toString()}")

                binding.tvTitle.text = response.body()!!.component1().name
                binding.tvLongDesc.text = response.body()!!.component1().house
                Glide.with(this@Info)
                    .load(response.body()!!.component1().image)
                    .into(binding.ivImage)
                binding.tvLongDesc2.text = response.body()!!.component1().actor
                binding.tvLongDesc3.text = response.body()!!.component1().ancestry
                binding.tvLongDesc4.text = response.body()!!.component1().patronus
                binding.tvLongDesc5.text = response.body()!!.component1().dateOfBirth
            }
            override fun onFailure(call: Call<ArrayList<HP>>, t: Throwable) {
                binding.pbConexion.visibility = View.GONE
                Toast.makeText(this@Info, "No hay conexión", Toast.LENGTH_SHORT).show()

            }


        })


            }


        }











/*
        call.enqueue(object : Callback<HPDetail> {
            override fun onResponse(
                call: Call<HPDetail>,
                response: Response<HPDetail>
            ) {
                binding.pbConexion.visibility = View.GONE
               binding.tvTitle.text = response.isSuccessful.toString()
             //   binding.tvTitle.text = response.toString()
  //              binding.tvLongDesc.text = response.body()!!.dateBirth

               // Glide.with(this@Info)
                 //   .load(response.body()!!.image)
                   // .into(binding.ivImage)

                Log.d(Constants.LOGTAG, "Respuesta del servidor: ${response}")
                Log.d(Constants.LOGTAG, "Datos: ${response.body().toString()}")
            }

            override fun onFailure(call: Call<HPDetail>, t: Throwable) {

                binding.pbConexion.visibility = View.GONE
                Toast.makeText(this@Info, "No hay conexión", Toast.LENGTH_SHORT).show()
            }


        })

    }
}*/