package com.joaovjusto.projeto_final.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Product(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val name: String,
        val description: String,
        val color: String,
        val type: String,
        val quantity: Int)