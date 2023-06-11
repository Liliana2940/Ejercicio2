package com.example.ejercicio2.model

import com.google.gson.annotations.SerializedName

data class HPDetail(

    @SerializedName("id")
    var id: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("image")
    var image: String,

    @SerializedName("actor")
    var actor: String,

    @SerializedName("house")
    var house: String,

    @SerializedName("dateOfBirth")
    var dateBirth: Int
)