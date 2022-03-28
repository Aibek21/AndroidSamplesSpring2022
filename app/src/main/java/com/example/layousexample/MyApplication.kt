package com.example.layousexample

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.layousexample.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MyApplication : Application() {
    private var database: AppDatabase? = null
    private var apiService: ApiService? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE user ADD COLUMN phone VARCHAR(50)")
            }
        }
        database = Room.databaseBuilder(this, AppDatabase::class.java, "user_db")
            .allowMainThreadQueries()
            .addMigrations(MIGRATION_1_2)
            .fallbackToDestructiveMigration()
            .build()


        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }


    fun getDatabase(): AppDatabase? {
        return database
    }

    fun getApiService(): ApiService? {
        return apiService
    }

    companion object {
        lateinit var instance: MyApplication
    }
}