package com.example.cats.ui.navigation

import kotlinx.serialization.Serializable

sealed class Screen {

    @Serializable
    data object Home : Screen()

    @Serializable
    data object Splash : Screen()

    @Serializable
    data class Detail(val catName: String, val description: String) : Screen()
}