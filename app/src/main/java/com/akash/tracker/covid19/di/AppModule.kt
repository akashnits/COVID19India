package com.akash.tracker.covid19.di

import android.app.Application
import androidx.room.Room
import com.akash.tracker.covid19.api.CovidService
import com.akash.tracker.covid19.db.*
import com.akash.tracker.covid19.util.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//instance of retrofit, database, dao can be provided from here
@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    @Singleton
    fun provideCovidService(): CovidService {
        return Retrofit.Builder()
            .baseUrl("https://api.covid19india.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(CovidService::class.java)
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(app: Application): CovidDb{
        return Room
            .databaseBuilder(app, CovidDb::class.java, "covid.db" )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(db: CovidDb): UserDao{
        return db.getUserDao()
    }

    @Provides
    @Singleton
    fun provideProductDao(db: CovidDb): CovidDao{
        return db.getCovidDao()
    }
}