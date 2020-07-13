package com.akash.aqua.aactemplate.di

import com.akash.aqua.aactemplate.ui.product.ProductFragment
import com.akash.aqua.aactemplate.ui.user.UserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributesUserFragment(): UserFragment

    @ContributesAndroidInjector
    abstract fun contributesProductFragment(): ProductFragment
}