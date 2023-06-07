package com.example.ejercicio2.view.activities


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio2.databinding.ActivityMainBinding
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio2.model.HP
import com.example.ejercicio2.network.HPApi
import com.example.ejercicio2.network.RetrofitService
import com.example.ejercicio2.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val call = RetrofitService.getRetrofit().create(HPApi::class.java)
            .getHP("/api/characters")  //Para Apiary
        //.getGames("cm/games/games_list.php") //Para www.serverbpw.com

        call.enqueue(object: Callback<ArrayList<HP>>{
            override fun onResponse(call: Call<ArrayList<HP>>, response: Response<ArrayList<HP>>) {
                binding.pbConexion.visibility=View.GONE
                Log.d(Constants.LOGTAG, "Respuesta del servidor: ${response.toString()}")
            }

            override fun onFailure(call: Call<ArrayList<HP>>, t: Throwable) {
                binding.pbConexion.visibility=View.GONE
                Toast.makeText(this@MainActivity, "No hay conexión", Toast.LENGTH_SHORT)
            }
        })
    }
}
