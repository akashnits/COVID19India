package com.akash.tracker.covid19.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akash.tracker.covid19.ui.product.ProductViewModel
import com.akash.tracker.covid19.ui.user.UserViewModel
import com.akash.tracker.covid19.viewmodel.AACTemplateViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

//using dagger multi bindings key - viewModel class, value - Provider<ViewModel>
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProductViewModel::class)
    abstract fun bindProductViewModel(productViewModel: ProductViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(userViewModel: UserViewModel): ViewModel


    @Binds
    abstract fun bindAACViewModelFactory(aacTemplateViewModelFactory: AACTemplateViewModelFactory): ViewModelProvider.Factory

}