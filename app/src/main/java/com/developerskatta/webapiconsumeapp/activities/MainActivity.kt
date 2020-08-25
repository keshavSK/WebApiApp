package com.developerskatta.webapiconsumeapp.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.developerskatta.webapiconsumeapp.R
import com.developerskatta.webapiconsumeapp.interfaces.ApiServices
import com.developerskatta.webapiconsumeapp.models.responses.CategoryResponse
import com.developerskatta.webapiconsumeapp.models.rest_api.RestAdapterContainer
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var userId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userId = "1"
        val service = RestAdapterContainer.getInstance().create(ApiServices::class.java)
        val call = service.getCategories(userId!!)

        call.enqueue(object : Callback<CategoryResponse> {
            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.localizedMessage}", Toast.LENGTH_LONG).show()
                Log.e("MainActivity", "onResponse: ${t.localizedMessage}")
            }

            override fun onResponse(
                call: Call<CategoryResponse>,
                response: Response<CategoryResponse>
            ) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        var categoryResponse = response.body()
                        if (categoryResponse?.getStatus() == 200) {
                            val gson = Gson()
                            val catResponse = gson.toJson(categoryResponse)
                            Log.e("MainActivity", "onResponse: $catResponse")
                        } else {
                            Toast.makeText(
                                this@MainActivity,
                                categoryResponse?.getMessage(),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                } else {
                    Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}