package com.example.cats.api


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    @SerialName("text") val text: String? = null,
    @SerialName("type") val type: String? = null,
)