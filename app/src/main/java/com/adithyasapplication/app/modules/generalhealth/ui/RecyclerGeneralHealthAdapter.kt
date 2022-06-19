package com.adithyasapplication.app.modules.generalhealth.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adithyasapplication.app.R
import com.adithyasapplication.app.databinding.RowGeneralHealth1Binding
import com.adithyasapplication.app.modules.generalhealth.`data`.model.GeneralHealth1RowModel
import kotlin.Int
import kotlin.collections.List

class RecyclerGeneralHealthAdapter(
  var list: List<GeneralHealth1RowModel>
) : RecyclerView.Adapter<RecyclerGeneralHealthAdapter.RowGeneralHealth1VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowGeneralHealth1VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_general_health1,parent,false)
    return RowGeneralHealth1VH(view)
  }

  override fun onBindViewHolder(holder: RowGeneralHealth1VH, position: Int) {
    val generalHealth1RowModel = GeneralHealth1RowModel()
    // TODO uncomment following line after integration with data source
    // val generalHealth1RowModel = list[position]
    holder.binding.generalHealth1RowModel = generalHealth1RowModel
  }

  override fun getItemCount(): Int = 3
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<GeneralHealth1RowModel>) {
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
      item: GeneralHealth1RowModel
    ) {
    }
  }

  inner class RowGeneralHealth1VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowGeneralHealth1Binding = RowGeneralHealth1Binding.bind(itemView)
  }
}
