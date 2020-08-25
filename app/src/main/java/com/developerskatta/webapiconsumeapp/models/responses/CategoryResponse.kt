package com.developerskatta.webapiconsumeapp.models.responses

import com.developerskatta.webapiconsumeapp.models.data_models.Category
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class CategoryResponse {

    @SerializedName("status")
    @Expose
    private var status: Int? = null

    @SerializedName("Message")
    @Expose
    private var message: String? = null

    @SerializedName("CartCount")
    @Expose
    private var cartCount: String? = null

    @SerializedName("Categories")
    @Expose
    private var categories: List<Category?>? = null

    fun getStatus(): Int? {
        return status
    }

    fun setStatus(status: Int?) {
        this.status = status
    }

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String?) {
        this.message = message
    }

    fun getCartCount(): String? {
        return cartCount
    }

    fun setCartCount(cartCount: String?) {
        this.cartCount = cartCount
    }

    fun getCategories(): List<Category?>? {
        return categories
    }

    fun setCategories(categories: List<Category?>?) {
        this.categories = categories
    }
}