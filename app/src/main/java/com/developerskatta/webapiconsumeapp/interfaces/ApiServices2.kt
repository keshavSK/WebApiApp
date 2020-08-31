package com.developerskatta.webapiconsumeapp.interfaces

import com.developerskatta.webapiconsumeapp.models.data_models.PhotoAlbumModel
import com.developerskatta.webapiconsumeapp.models.responses.Category_1_Response
import com.developerskatta.webapiconsumeapp.models.responses.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices2 {

    @GET("api/get_categories")
    fun getCategories(@Query("user_id") userId: String): Call<Category_1_Response>

    @GET("photos")
    fun getPhotoAlbum(): Call<List<PhotoAlbumModel>>

    @GET("v2/top-headlines")
    fun getTopHeadings(
        @Query("apiKey") apiKey: String,
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("source") source: String
    ): Call<NewsResponse>
}