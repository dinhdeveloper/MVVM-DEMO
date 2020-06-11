package com.mobishop.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CategoryModel(
    @SerializedName("categoryId")
    val categoryId: Int=0,
    @SerializedName("categoryImage")
    val categoryImage: String="",
    @SerializedName("categoryName")
    val categoryName: String="",
    @SerializedName("promotionId")
    val promotionId: Int=0
) : Serializable