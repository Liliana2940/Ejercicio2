package com.example.ejercicio2.view.activities


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio2.databinding.ActivityMainStudentBinding
import com.example.ejercicio2.model.HP
import com.example.ejercicio2.network.HPApi
import com.example.ejercicio2.network.RetrofitService
import com.example.ejercicio2.utils.Constants
import com.example.ejercicio2.view.adapters.HPAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainStudent : AppCompatActivity() {
    private lateinit var binding: ActivityMainStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val student = bundle?.getString("student", "")


        val call = RetrofitService.getRetrofit().create(HPApi::class.java)
            .getHP("/api/characters/students")  //Para Apiary
        //.getGames("cm/games/games_list.php") //Para www.serverbpw.com

        call.enqueue(object: Callback<ArrayList<HP>>{
            override fun onResponse(call: Call<ArrayList<HP>>, response: Response<ArrayList<HP>>) {
                binding.pbConexion.visibility=View.GONE
                Log.d(Constants.LOGTAG, "Respuesta del servidor: ${response.toString()}")
                Log.d(Constants.LOGTAG, "Datos: ${response.body().toString()}")



                binding.idMenu.layoutManager = LinearLayoutManager(this@MainStudent)
                //binding.idMenu.adapter = HPAdapter(this@MainActivity, response.body()!!,response.body()!!.component1().student) { selectedHP ->
                binding.idMenu.adapter = HPAdapter(this@MainStudent, response.body()!!) { selectedHP ->
                    hpClicked(selectedHP)
                }


            }

            override fun onFailure(call: Call<ArrayList<HP>>, t: Throwable) {
                binding.pbConexion.visibility=View.GONE
                Toast.makeText(this@MainStudent, "No hay conexión", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun hpClicked(hp: HP){

        // Toast.makeText(this, "Click en el elemento con titulo ${hp.name}", Toast.LENGTH_SHORT).show()

        val bundle = Bundle()
        bundle.putString("id", hp.id)
        val intent = Intent(this,Info::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

}