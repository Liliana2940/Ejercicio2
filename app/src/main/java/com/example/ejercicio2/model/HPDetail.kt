package com.example.ejercicio2.model

import com.google.gson.annotations.SerializedName

data class HPDetail(
    @SerializedName("name")
    var name: String?,

    @SerializedName("image")
    var image: String?,

    @SerializedName("actor")
    var actor: String?,

    @SerializedName("house")
    var house: String?


)