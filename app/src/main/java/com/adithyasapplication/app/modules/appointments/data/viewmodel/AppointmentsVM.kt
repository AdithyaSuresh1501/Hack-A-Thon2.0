package com.adithyasapplication.app.modules.appointments.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adithyasapplication.app.appcomponents.utility.PreferenceHelper
import com.adithyasapplication.app.modules.appointments.`data`.model.AppointmentsModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class AppointmentsVM : ViewModel(), KoinComponent {
  val appointmentsModel: MutableLiveData<AppointmentsModel> = MutableLiveData(AppointmentsModel())

  var navArguments: Bundle? = null

  private val prefs: PreferenceHelper by inject()

  fun bindPrefsData() {
    appointmentsModel.value?.txtAdithya = prefs.getName()
  }
}
