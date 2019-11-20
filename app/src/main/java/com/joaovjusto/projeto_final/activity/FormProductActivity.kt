package com.joaovjusto.projeto_final.activity

import com.joaovjusto.projeto_final.R
import com.joaovjusto.projeto_final.database.AppDatabase
import com.joaovjusto.projeto_final.database.dao.ProductDao
import com.joaovjusto.projeto_final.model.Product
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_form_product.*

class FormProductActivity : AppCompatActivity() {

    private lateinit var productDao: ProductDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_product)
        val database = Room.databaseBuilder(
                this,
                AppDatabase::class.java,
                "projeto")
                .allowMainThreadQueries()
                .build()
        productDao = database.productDao()
        configureSaveButton()
    }

    private fun configureSaveButton() {
        form_product_save_button.setOnClickListener {
            saveProduct()
            finish()
        }
    }

    private fun saveProduct() {
        val createdProduct = create()
        productDao.add(createdProduct)
    }

    private fun create(): Product {
        val name = findViewById<EditText>(R.id.form_product_name)
        val description = findViewById<EditText>(R.id.form_product_description)
        val quantity = findViewById<EditText>(R.id.form_product_quantity)
        val color = findViewById<EditText>(R.id.form_product_color)
        val type = findViewById<EditText>(R.id.form_product_type)
        return Product(name = name.text.toString(), description = description.text.toString(), quantity = quantity.text.toString().toInt(), color = color.text.toString(), type = type.text.toString())
    }
}
