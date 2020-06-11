package com.mobishop.api


import com.mobishop.model.CategoryModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIServiceInterface {

    @GET("category/list")
    fun getAllCategory(): Call<List<CategoryModel>>
}