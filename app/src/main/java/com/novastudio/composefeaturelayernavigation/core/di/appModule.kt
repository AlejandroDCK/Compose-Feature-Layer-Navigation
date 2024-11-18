package com.novastudio.composefeaturelayernavigation.core.di

import com.novastudio.composefeaturelayernavigation.core.navigation.Mobile
import com.novastudio.composefeaturelayernavigation.feature_a.presentation.ScreenAViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<Mobile> { Mobile("Samsung", 1000.0, "Black", 6.5) }
    viewModel { ScreenAViewModel(get()) }
}