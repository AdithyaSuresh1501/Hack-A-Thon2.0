package com.adithyasapplication.app.modules.splashscreen.`data`.model

import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class SplashScreenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHealthi: String? = MyApp.getInstance().resources.getString(R.string.lbl_healthi)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtZee: String? = MyApp.getInstance().resources.getString(R.string.lbl_zee)

)
