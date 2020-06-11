package com.mobishop.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mobishop.api.APIClient
import com.mobishop.api.APIServiceInterface
import com.mobishop.api.APIUntil
import com.mobishop.model.CategoryModel
import retrofit2.Call
import retrofit2.Response

class CategoryRepository {

    private var apiInterfaceInterface: APIServiceInterface? = null

     fun dataAPI(): MutableLiveData<List<CategoryModel>> {
        val data: MutableLiveData<List<CategoryModel>> = MutableLiveData<List<CategoryModel>>()
        apiInterfaceInterface = APIUntil.server
        apiInterfaceInterface!!.getAllCategory()
            .enqueue(object : retrofit2.Callback<List<CategoryModel>> {
                override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                    Log.e("onFailure", t.message)
                }

                override fun onResponse(
                    call: Call<List<CategoryModel>>,
                    response: Response<List<CategoryModel>>
                ) {
                    if (response.isSuccessful){
                        data.postValue(response.body())
                    }
                }

            })
        return data
    }
}