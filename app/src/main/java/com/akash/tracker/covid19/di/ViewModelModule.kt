package com.akash.tracker.covid19.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akash.tracker.covid19.ui.home.CovidViewModel
import com.akash.tracker.covid19.ui.user.UserViewModel
import com.akash.tracker.covid19.viewmodel.CovidAppViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

//using dagger multi bindings key - viewModel class, value - Provider<ViewModel>
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CovidViewModel::class)
    abstract fun bindCovidViewModel(covidViewModel: CovidViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(userViewModel: UserViewModel): ViewModel


    @Binds
    abstract fun bindCovidViewModelFactory(covidAppViewModelFactory: CovidAppViewModelFactory): ViewModelProvider.Factory

}