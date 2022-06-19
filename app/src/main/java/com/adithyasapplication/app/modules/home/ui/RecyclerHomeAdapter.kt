package com.adithyasapplication.app.modules.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adithyasapplication.app.R
import com.adithyasapplication.app.databinding.RowHome1Binding
import com.adithyasapplication.app.modules.home.`data`.model.Home1RowModel
import kotlin.Int
import kotlin.collections.List

class RecyclerHomeAdapter(
  var list: List<Home1RowModel>
) : RecyclerView.Adapter<RecyclerHomeAdapter.RowHome1VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHome1VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_home1,parent,false)
    return RowHome1VH(view)
  }

  override fun onBindViewHolder(holder: RowHome1VH, position: Int) {
    val home1RowModel = Home1RowModel()
    // TODO uncomment following line after integration with data source
    // val home1RowModel = list[position]
    holder.binding.home1RowModel = home1RowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Home1RowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: Home1RowModel
    ) {
    }
  }

  inner class RowHome1VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowHome1Binding = RowHome1Binding.bind(itemView)
  }
}
