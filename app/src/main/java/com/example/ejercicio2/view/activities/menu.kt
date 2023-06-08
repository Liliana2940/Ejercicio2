package com.example.ejercicio2.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ejercicio2.R
import com.example.ejercicio2.databinding.ActivityInfoBinding
import com.example.ejercicio2.databinding.ActivityMenuBinding
import com.example.ejercicio2.model.HP
import com.google.android.material.bottomnavigation.BottomNavigationView

class menu : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val botonEst = findViewById<Button>(R.id.idBotEstudiantes)
        val botonPers = findViewById<Button>(R.id.idBotPersonal)



        // Toast.makeText(this, "Click en el elemento con titulo ${hp.name}", Toast.LENGTH_SHORT).show()
        botonEst.setOnClickListener {
            val bundle = Bundle()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        botonPers.setOnClickListener {
            val bundle = Bundle()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}