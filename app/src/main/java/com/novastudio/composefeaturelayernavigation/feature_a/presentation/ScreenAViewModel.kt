package com.novastudio.composefeaturelayernavigation.feature_a.presentation

import androidx.lifecycle.ViewModel
import com.novastudio.composefeaturelayernavigation.core.navigation.Mobile

class ScreenAViewModel(
    private val mobile: Mobile
) : ViewModel() {

    fun injectMobile(): Mobile {
        return mobile
    }
}