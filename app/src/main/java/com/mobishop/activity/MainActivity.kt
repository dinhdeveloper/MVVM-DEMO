package com.mobishop.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobishop.adapter.CategoryAdapter
import com.mobishop.model.CategoryModel
import com.mobishop.viewmodel.CategoryViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var mViewModel: CategoryViewModel? = null
    private var categoryAdapter: CategoryAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)
        //mViewModel!!.init()
        mViewModel!!.getData()?.observe(this, Observer { data ->
            rcView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            rcView.adapter = CategoryAdapter(this, data, onClick = {
                Toast.makeText(this,"${it.categoryName}",Toast.LENGTH_LONG).show()
            })
            categoryAdapter?.notifyDataSetChanged()
        })

        addEvent()
    }

    private fun addEvent() {
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        rcView.layoutManager = mLayoutManager
        rcView.adapter = categoryAdapter
    }
}