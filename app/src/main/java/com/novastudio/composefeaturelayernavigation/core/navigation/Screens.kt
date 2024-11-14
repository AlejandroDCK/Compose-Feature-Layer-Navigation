package com.novastudio.composefeaturelayernavigation.core.navigation
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
object HomeScreen

@Serializable
object ScreenA

@Serializable
data class ScreenB(val mobile: Mobile)

@Serializable
@Parcelize
data class Mobile(
    val model: String,
    val price: Double,
    val color: String,
    val screenSize: Double
) : Parcelable