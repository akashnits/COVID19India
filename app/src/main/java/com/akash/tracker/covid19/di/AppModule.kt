package com.akash.tracker.covid19.di

import android.app.Application
import androidx.room.Room
import com.akash.tracker.covid19.api.ProductService
import com.akash.tracker.covid19.db.ProductDao
import com.akash.tracker.covid19.db.ProductDb
import com.akash.tracker.covid19.db.UserDao
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
    fun provideProductService(): ProductService {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(ProductService::class.java)
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(app: Application): ProductDb{
        return Room
            .databaseBuilder(app, ProductDb::class.java, "productDb" )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(db: ProductDb): UserDao{
        return db.getUserDao()
    }

    @Provides
    @Singleton
    fun provideProductDao(db: ProductDb): ProductDao{
        return db.getProductDao()
    }
}