package com.adithyasapplication.app.modules.letsgetstarted.`data`.model

import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class LetsGetStartedModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLetsgetHealt: String? =
      MyApp.getInstance().resources.getString(R.string.msg_let_s_get_healt)

)
