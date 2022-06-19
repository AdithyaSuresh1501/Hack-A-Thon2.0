package com.adithyasapplication.app.modules.home.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.base.BaseActivity
import com.adithyasapplication.app.databinding.ActivityHomeBinding
import com.adithyasapplication.app.modules.home.`data`.model.Home1RowModel
import com.adithyasapplication.app.modules.home.`data`.viewmodel.HomeVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {
  private val viewModel: HomeVM by viewModels<HomeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val recyclerHomeAdapter =
    RecyclerHomeAdapter(viewModel.recyclerHomeList.value?:mutableListOf())
    binding.recyclerHome.adapter = recyclerHomeAdapter
    recyclerHomeAdapter.setOnItemClickListener(
    object : RecyclerHomeAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Home1RowModel) {
        onClickRecyclerHome(view, position, item)
      }
    }
    )
    viewModel.recyclerHomeList.observe(this) {
      recyclerHomeAdapter.updateData(it)
    }
    binding.homeVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerHome(
    view: View,
    position: Int,
    item: Home1RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "HOME_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HomeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
