package com.developerskatta.webapiconsumeapp.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.developerskatta.webapiconsumeapp.R
import com.developerskatta.webapiconsumeapp.adapters.NewsHeadingAdapter
import com.developerskatta.webapiconsumeapp.interfaces.ApiServices2
import com.developerskatta.webapiconsumeapp.models.responses.NewsResponse
import com.developerskatta.webapiconsumeapp.models.rest_api.RestAdapterContainer
import com.developerskatta.webapiconsumeapp.utils.Constants.Companion.NEWS_API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopHeadingNewsActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var progressBar: ProgressBar? = null
    var country = "in"
    var category = "technology"
    var source = "bbc-news"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_heading_news)
        recyclerView = findViewById(R.id.recyclerViewTopHeadings)
        progressBar = findViewById(R.id.progressBar)
        recyclerView?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        // create instance of service class
        val service = RestAdapterContainer.getInstance().create(ApiServices2::class.java)
        // get call from retrofit
        val call = service.getTopHeadings(NEWS_API_KEY, country, category, source)
        progressBar?.visibility = View.VISIBLE
        call.enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                progressBar?.visibility = View.GONE
                Log.e(Companion.TAG, "onFailure: ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.body() != null) {
                    progressBar?.visibility = View.GONE
                    if (response.body()!!.status == "ok") {
                        val articlesList = response.body()!!.articles
                        val adapter = NewsHeadingAdapter(articlesList)
                        recyclerView?.adapter = adapter
                        adapter.notifyDataSetChanged()
                    } else if (response.body()!!.status == "error") {
                        val message = response.body()!!.message
                        Toast.makeText(
                            this@TopHeadingNewsActivity,
                            "$message",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    progressBar?.visibility = View.GONE
                    Toast.makeText(
                        this@TopHeadingNewsActivity,
                        "Response not available",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        })
    }

    companion object {
        private const val TAG = "TopHeadingNewsActivity"
    }
}