package com.akash.tracker.covid19.di

import com.akash.tracker.covid19.ui.product.ProductFragment
import com.akash.tracker.covid19.ui.user.UserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributesUserFragment(): UserFragment

    @ContributesAndroidInjector
    abstract fun contributesProductFragment(): ProductFragment
}