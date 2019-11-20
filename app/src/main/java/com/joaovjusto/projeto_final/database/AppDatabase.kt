package com.joaovjusto.projeto_final.database

import com.joaovjusto.projeto_final.database.dao.ProductDao
import com.joaovjusto.projeto_final.model.Product
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}