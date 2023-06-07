package com.example.ejercicio2.network

import com.example.ejercicio2.model.HP
import com.example.ejercicio2.model.HPDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface HPApi {

    @GET
    fun getHP(
    @Url url: String? = null
    ): Call<ArrayList<HP>>

    @GET("/api/characters")
    fun getHPDetail(
        @Query("id") id: String? = null,
        @Query("name") name: String? = null
    ): Call<HPDetail>

    @GET("/api/characters/{id}")
    fun getGameDetailApiary(
        @Path("id") id:String?
    ): Call<HPDetail>

}