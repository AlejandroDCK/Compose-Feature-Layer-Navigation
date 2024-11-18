package com.novastudio.composefeaturelayernavigation.feature_a.presentation

import androidx.lifecycle.ViewModel
import com.novastudio.composefeaturelayernavigation.core.navigation.Mobile
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScreenAViewModel @Inject constructor(
    private val mobile: Mobile
): ViewModel() {

    fun injectMobile(): Mobile {
        return mobile
    }
}