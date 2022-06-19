package com.adithyasapplication.app.modules.letsgetstarted.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adithyasapplication.app.modules.letsgetstarted.`data`.model.LetsGetStartedModel
import org.koin.core.KoinComponent

class LetsGetStartedVM : ViewModel(), KoinComponent {
  val letsGetStartedModel: MutableLiveData<LetsGetStartedModel> =
      MutableLiveData(LetsGetStartedModel())

  var navArguments: Bundle? = null
}
