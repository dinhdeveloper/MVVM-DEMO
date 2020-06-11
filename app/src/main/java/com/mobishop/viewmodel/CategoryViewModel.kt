package com.mobishop.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobishop.model.CategoryModel
import com.mobishop.repositories.CategoryRepository

class CategoryViewModel : ViewModel() {

    private var data: MutableLiveData<List<CategoryModel>> = MutableLiveData()
    private val categoryModel: CategoryRepository=  CategoryRepository()


    fun init() {
        //gán data lấy từ api về cho data trong viewmodel
        //data = categoryModel.dataAPI()
    }

    //truyền data sang cho activity
    fun getData(): MutableLiveData<List<CategoryModel>>? {
        //gán data lấy từ api về cho data trong viewmodel
        data = categoryModel.dataAPI()
        return data
    }
}