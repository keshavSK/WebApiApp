package com.developerskatta.webapiconsumeapp.models.responses

import com.developerskatta.webapiconsumeapp.models.data_models.ArticlesModel
import java.io.Serializable

class NewsResponse : Serializable {
    var status: String? = null
    var message: String? = null
    var totalResults: Int? = null
    var articles: List<ArticlesModel?>? = null
}