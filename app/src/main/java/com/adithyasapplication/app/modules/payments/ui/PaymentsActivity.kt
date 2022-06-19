package com.adithyasapplication.app.modules.payments.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.base.BaseActivity
import com.adithyasapplication.app.databinding.ActivityPaymentsBinding
import com.adithyasapplication.app.modules.appointments.ui.AppointmentsActivity
import com.adithyasapplication.app.modules.generalhealth.ui.GeneralHealthActivity
import com.adithyasapplication.app.modules.payments.`data`.viewmodel.PaymentsVM
import kotlin.String
import kotlin.Unit

class PaymentsActivity : BaseActivity<ActivityPaymentsBinding>(R.layout.activity_payments) {
  private val viewModel: PaymentsVM by viewModels<PaymentsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.paymentsVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageFoundationclip.setOnClickListener {
      val destIntent = AppointmentsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageBxrupee.setOnClickListener {
      val destIntent = GeneralHealthActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "PAYMENTS_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, PaymentsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
