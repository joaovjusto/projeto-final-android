package com.joaovjusto.projeto_final.ui.activity

import com.joaovjusto.projeto_final.R
import com.joaovjusto.projeto_final.database.AppDatabase
import com.joaovjusto.projeto_final.database.dao.ProductDao
import com.joaovjusto.projeto_final.ui.activity.recyclerview.ProductsListAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.joaovjusto.projeto_final.activity.FormProductActivity
import kotlinx.android.synthetic.main.activity_products_list.*


class ProductsListActivity : AppCompatActivity() {

    private lateinit var productDao: ProductDao
    private lateinit var adapter: ProductsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list)
        val database = Room.databaseBuilder(
                this,
                AppDatabase::class.java,
                "projeto")
                .allowMainThreadQueries()
                .build()
        productDao = database.productDao()
        configureRecyclerView()
        configureFabAddProduct()
    }

    private fun configureFabAddProduct() {
        product_list_add_product.setOnClickListener {
            val openProductForm = Intent(this, FormProductActivity::class.java)
            startActivity(openProductForm)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.replaceAllProducts(productDao.all())
    }

    private fun configureRecyclerView() {
        this.adapter = ProductsListAdapter(context = this)
        products_list_recyclerview.adapter = adapter
    }

}
