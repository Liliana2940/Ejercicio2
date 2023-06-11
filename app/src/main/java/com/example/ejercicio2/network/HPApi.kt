package com.example.ejercicio2.network

import com.example.ejercicio2.model.HP
import com.example.ejercicio2.model.HPDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap
import retrofit2.http.QueryName
import retrofit2.http.Url

interface HPApi {

    @GET
    fun getHP(
    @Url url: String?
    ): Call<ArrayList<HP>>

    @GET("character/{id}")
    fun getHPDetail(
        //@Path("id") id: String?
       // @Url id: String?
        @QueryName(encoded = false) id:String? = null
    ): Call<HPDetail>

    @GET("character/")
    fun getHPDetailApiary(
        @Url id: String?
    ): Call<HPDetail>

    @GET("character/{id}")
    fun getHPDetailText(@Path("id") id: String?
    ): Call<HPDetail>
//https://hp-api.onrender.com/api/characters

}