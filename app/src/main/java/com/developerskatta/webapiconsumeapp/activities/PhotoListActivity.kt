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
import com.developerskatta.webapiconsumeapp.adapters.PhotoAlbumAdapter
import com.developerskatta.webapiconsumeapp.interfaces.ApiServices2
import com.developerskatta.webapiconsumeapp.models.data_models.PhotoAlbumModel
import com.developerskatta.webapiconsumeapp.models.rest_api.RestAdapterContainer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoListActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var progressBar: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list)
        recyclerView = findViewById(R.id.recyclerViewPhotoAlbum)
        recyclerView?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        progressBar = findViewById(R.id.progressBar)
        progressBar?.visibility = View.VISIBLE
        val service = RestAdapterContainer.getInstance().create(ApiServices2::class.java)
        val call = service.getPhotoAlbum()
        call.enqueue(object : Callback<List<PhotoAlbumModel>> {
            override fun onFailure(call: Call<List<PhotoAlbumModel>>, t: Throwable) {
                progressBar?.visibility = View.GONE
                Log.e(Companion.TAG, "onFailure: ${t.localizedMessage}")
            }

            override fun onResponse(
                call: Call<List<PhotoAlbumModel>>,
                response: Response<List<PhotoAlbumModel>>
            ) {
                progressBar?.visibility = View.GONE
                if (response.body() == null) {
                    Toast.makeText(this@PhotoListActivity, "Response available", Toast.LENGTH_LONG)
                        .show()
                } else {
                    val albumList = response.body()
                    val adapter = PhotoAlbumAdapter(albumList!!)
                    recyclerView?.adapter = adapter
                    adapter.notifyDataSetChanged()
                }
            }
        })
    }

    companion object {
        private const val TAG = "PhotoListActivity"
    }
}