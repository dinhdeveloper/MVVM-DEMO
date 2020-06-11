package com.mobishop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobishop.activity.R
import com.mobishop.model.CategoryModel

class CategoryAdapter(
    private val context: Context,
    private val listCate: List<CategoryModel>,
    private val onClick: (CategoryModel) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(context).inflate(R.layout.custom_item_category, parent, false)
        return ViewHolder(view, onClick)
    }

    override fun getItemCount(): Int {
        return listCate.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (context != null) {
            Glide.with(context).load(listCate[position].categoryImage).into(holder.imageCate!!)
            holder.nameCate?.text = listCate[position].categoryName
        }
    }

    inner class ViewHolder(view: View, val onClick: (CategoryModel) -> Unit) :
        RecyclerView.ViewHolder(view) {
        var imageCate: ImageView? = view?.findViewById(R.id.imageCate)
        var nameCate: TextView? = view?.findViewById(R.id.nameCate)

        init {
            itemView?.setOnClickListener {
                onClick.invoke(listCate[adapterPosition])
            }
        }
    }

}
