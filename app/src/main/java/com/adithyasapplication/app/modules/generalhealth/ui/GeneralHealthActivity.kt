package com.adithyasapplication.app.modules.generalhealth.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.base.BaseActivity
import com.adithyasapplication.app.databinding.ActivityGeneralHealthBinding
import com.adithyasapplication.app.modules.appointments.ui.AppointmentsActivity
import com.adithyasapplication.app.modules.generalhealth.`data`.model.GeneralHealth1RowModel
import com.adithyasapplication.app.modules.generalhealth.`data`.viewmodel.GeneralHealthVM
import com.adithyasapplication.app.modules.payments.ui.PaymentsActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class GeneralHealthActivity :
    BaseActivity<ActivityGeneralHealthBinding>(R.layout.activity_general_health) {
  private val viewModel: GeneralHealthVM by viewModels<GeneralHealthVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val recyclerGeneralHealthAdapter =
    RecyclerGeneralHealthAdapter(viewModel.recyclerGeneralHealthList.value?:mutableListOf())
    binding.recyclerGeneralHealth.adapter = recyclerGeneralHealthAdapter
    recyclerGeneralHealthAdapter.setOnItemClickListener(
    object : RecyclerGeneralHealthAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : GeneralHealth1RowModel) {
        onClickRecyclerGeneralHealth(view, position, item)
      }
    }
    )
    viewModel.recyclerGeneralHealthList.observe(this) {
      recyclerGeneralHealthAdapter.updateData(it)
    }
    binding.generalHealthVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageFoundationclip.setOnClickListener {
      val destIntent = AppointmentsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageIcoutlineheal.setOnClickListener {
      val destIntent = PaymentsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerGeneralHealth(
    view: View,
    position: Int,
    item: GeneralHealth1RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "GENERAL_HEALTH_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, GeneralHealthActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
