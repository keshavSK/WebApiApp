package com.developerskatta.webapiconsumeapp.models.data_models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Category {
    @SerializedName("CategoryId")
    @Expose
    private var categoryId: String? = null

    @SerializedName("Category")
    @Expose
    private var category: String? = null

    @SerializedName("SequenceNo")
    @Expose
    private var sequenceNo: String? = null

    @SerializedName("MediaUrl")
    @Expose
    private var mediaUrl: String? = null

    @SerializedName("IconMediaUrl")
    @Expose
    private var iconMediaUrl: String? = null

    fun getCategoryId(): String? {
        return categoryId
    }

    fun setCategoryId(categoryId: String?) {
        this.categoryId = categoryId
    }

    fun getCategory(): String? {
        return category
    }

    fun setCategory(category: String?) {
        this.category = category
    }

    fun getSequenceNo(): String? {
        return sequenceNo
    }

    fun setSequenceNo(sequenceNo: String?) {
        this.sequenceNo = sequenceNo
    }

    fun getMediaUrl(): String? {
        return mediaUrl
    }

    fun setMediaUrl(mediaUrl: String?) {
        this.mediaUrl = mediaUrl
    }

    fun getIconMediaUrl(): String? {
        return iconMediaUrl
    }

    fun setIconMediaUrl(iconMediaUrl: String?) {
        this.iconMediaUrl = iconMediaUrl
    }
}