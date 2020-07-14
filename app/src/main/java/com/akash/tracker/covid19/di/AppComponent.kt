package com.akash.tracker.covid19.di

import com.akash.tracker.covid19.COVID19App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, MainActivityModule::class])
interface AppComponent {
    @Component.Builder
        interface Builder{
            @BindsInstance
            fun application(COVID19App: COVID19App): Builder
            fun build(): AppComponent
    }

    fun inject(app: COVID19App)
}