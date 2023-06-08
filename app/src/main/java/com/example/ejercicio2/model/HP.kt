package com.example.ejercicio2.model
import com.google.gson.annotations.SerializedName
data class HP(

        @SerializedName("id")
        var id: String?,
        @SerializedName("image")
        var image: String?,
        @SerializedName("name")
        var name: String?,
        @SerializedName("actor")
        var actor: String?,
        @SerializedName("house")
        var house: String?

)