package com.developerskatta.webapiconsumeapp.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.developerskatta.webapiconsumeapp.R
import com.developerskatta.webapiconsumeapp.adapters.CategoryAdapter
import com.developerskatta.webapiconsumeapp.interfaces.ApiServices2
import com.developerskatta.webapiconsumeapp.models.responses.Category_1_Response
import com.developerskatta.webapiconsumeapp.models.rest_api.RestAdapterContainer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    val userId = "2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        recyclerView = findViewById(R.id.recyclerCategoryList)
        recyclerView!!.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val service = RestAdapterContainer.getInstance().create(ApiServices2::class.java)
        val call = service.getCategories(userId)
        call.enqueue(object : Callback<Category_1_Response> {
            override fun onFailure(call: Call<Category_1_Response>, t: Throwable) {
                Log.i(Companion.TAG, "onFailure: ${t.localizedMessage}")
            }

            override fun onResponse(
                call: Call<Category_1_Response>,
                response: Response<Category_1_Response>
            ) {
                if (response.body() == null) {
                    Toast.makeText(
                        this@CategoryActivity,
                        "Response not available",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    if (response.body()!!.status == 200) {
                        var list = response.body()!!.Categories
                        var adapter = CategoryAdapter(list)
                        recyclerView!!.adapter = adapter
                    } else {
                        Toast.makeText(
                            this@CategoryActivity,
                            "${response.body()!!.Message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

        })
    }

    companion object {
        private const val TAG = "CategoryActivity"
    }
}