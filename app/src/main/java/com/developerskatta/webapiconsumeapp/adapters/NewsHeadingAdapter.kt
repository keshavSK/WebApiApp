package com.developerskatta.webapiconsumeapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.developerskatta.webapiconsumeapp.R
import com.developerskatta.webapiconsumeapp.models.data_models.ArticlesModel
import com.squareup.picasso.Picasso

class NewsHeadingAdapter(var list: List<ArticlesModel?>?) :
    RecyclerView.Adapter<NewsHeadingAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById<TextView>(R.id.tv_row_news_title)
        val tvNewsDate = itemView.findViewById<TextView>(R.id.tv_row_news_date)
        val tvSource = itemView.findViewById<TextView>(R.id.tv_row_news_source)
        val imgNewsImage = itemView.findViewById<ImageView>(R.id.imgNewsThumbnail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_news_heading, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sourceModel = list?.get(position)?.source
        val sourceName = sourceModel?.name
        val sourceId = sourceModel?.id
        holder.tvTitle.text = list?.get(position)?.title
        holder.tvNewsDate.text =
            list?.get(position)?.publishedAt
        holder.tvSource.text = sourceName

        if (list?.get(position)?.urlToImage == null) {
            Picasso.get().load(R.drawable.ic_launcher_background).into(holder.imgNewsImage)
        } else {
            Picasso.get().load(list?.get(position)?.urlToImage).into(holder.imgNewsImage)
        }
    }
}