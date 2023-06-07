package com.example.ejercicio2.model

import com.google.gson.annotations.SerializedName

data class HPDetail(
    @SerializedName("title")
    var title: String?,

    @SerializedName("image")
    var image: String?,

    @SerializedName("long_desc")
    var longDesc: String?
)