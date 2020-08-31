package com.developerskatta.webapiconsumeapp.models.data_models

import java.io.Serializable

class ArticlesModel : Serializable {
    var author: String? = null
    var title: String? = null
    var description: String? = null
    var urlToImage: String? = null
    var publishedAt: String? = null
    var content: String? = null
    var source: SourceModel? = null
}