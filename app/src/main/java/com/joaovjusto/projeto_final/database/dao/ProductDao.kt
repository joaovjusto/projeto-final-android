package com.joaovjusto.projeto_final.database.dao

import com.joaovjusto.projeto_final.model.Product
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun all(): List<Product>

    @Insert
    fun add(vararg product: Product)

}