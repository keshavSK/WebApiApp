package com.developerskatta.webapiconsumeapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.developerskatta.webapiconsumeapp.R
import com.developerskatta.webapiconsumeapp.models.data_models.CategoryModel

class CategoryAdapter(var list: List<CategoryModel?>?) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCategoryName = itemView.findViewById<TextView>(R.id.tvRowCategoryName)
        val tvCategoryUrl = itemView.findViewById<TextView>(R.id.tvRowCategoryUrl)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_category, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvCategoryName.text = list?.get(position)!!.Category
        holder.tvCategoryUrl.text = list?.get(position)!!.MediaUrl
    }
}