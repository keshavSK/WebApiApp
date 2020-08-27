package com.developerskatta.webapiconsumeapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.developerskatta.webapiconsumeapp.R
import com.developerskatta.webapiconsumeapp.models.data_models.PhotoAlbumModel
import com.squareup.picasso.Picasso

class PhotoAlbumAdapter(var photoAlbumList: List<PhotoAlbumModel>) :
    RecyclerView.Adapter<PhotoAlbumAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgThumbnail = itemView.findViewById<ImageView>(R.id.imgThumbnail)
        var tvAlbumName = itemView.findViewById<TextView>(R.id.tvAlbumTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_photo_album, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return photoAlbumList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvAlbumName.text = photoAlbumList[position].title
        if (photoAlbumList[position].thumbnailUrl == null) {
            Picasso.get().load("").placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.imgThumbnail)
        } else {
            Picasso.get().load(photoAlbumList[position].thumbnailUrl)
                .placeholder(R.drawable.ic_launcher_background).into(holder.imgThumbnail)
        }

    }
}