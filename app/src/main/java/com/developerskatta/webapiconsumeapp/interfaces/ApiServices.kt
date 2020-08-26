package com.developerskatta.webapiconsumeapp.interfaces

import com.developerskatta.webapiconsumeapp.models.responses.CategoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("api/get_categories")
    fun getCategories(@Query("user_id") userId: String): Call<CategoryResponse>

    @GET("api/get_products")
    fun getProducts(@Query("user_id") userId: String): Call<CategoryResponse>
}
