package com.adithyasapplication.app.modules.payments.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adithyasapplication.app.modules.payments.`data`.model.PaymentsModel
import org.koin.core.KoinComponent

class PaymentsVM : ViewModel(), KoinComponent {
  val paymentsModel: MutableLiveData<PaymentsModel> = MutableLiveData(PaymentsModel())

  var navArguments: Bundle? = null
}
