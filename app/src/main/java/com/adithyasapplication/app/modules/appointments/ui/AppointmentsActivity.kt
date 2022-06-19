package com.adithyasapplication.app.modules.appointments.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.base.BaseActivity
import com.adithyasapplication.app.databinding.ActivityAppointmentsBinding
import com.adithyasapplication.app.modules.appointments.`data`.viewmodel.AppointmentsVM
import kotlin.String
import kotlin.Unit

class AppointmentsActivity :
    BaseActivity<ActivityAppointmentsBinding>(R.layout.activity_appointments) {
  private val viewModel: AppointmentsVM by viewModels<AppointmentsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.appointmentsVM = viewModel
    viewModel.bindPrefsData()
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "APPOINTMENTS_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AppointmentsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
