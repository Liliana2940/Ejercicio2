package com.example.ejercicio2.model
import com.google.gson.annotations.SerializedName
data class HP(

        @SerializedName("id")
        var id: String?,
        @SerializedName("thumbnail")
        var thumbnail: String?,
        @SerializedName("title")
        var title: String?

)