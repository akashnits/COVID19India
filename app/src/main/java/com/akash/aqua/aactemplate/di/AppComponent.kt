package com.akash.aqua.aactemplate.di

import com.akash.aqua.aactemplate.AACTemplateApp
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
            fun application(aacTemplateApp: AACTemplateApp): Builder
            fun build(): AppComponent
    }

    fun inject(app: AACTemplateApp)
}