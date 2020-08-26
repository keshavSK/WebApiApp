package com.developerskatta.webapiconsumeapp.interfaces

import com.developerskatta.webapiconsumeapp.models.responses.Category_1_Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices2 {

    @GET("api/get_categories")
    fun getCategories(@Query("user_id") userId: String): Call<Category_1_Response>

    @GET("api/get_categories")
    fun getProducts(@Query("user_id") userId: String): Call<Category_1_Response>

    @GET("api/get_categories")
    fun getUser(@Query("user_id") userId: String): Call<Category_1_Response>
}