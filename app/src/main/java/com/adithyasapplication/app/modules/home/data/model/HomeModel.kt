package com.adithyasapplication.app.modules.home.`data`.model

import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class HomeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_hello)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAdithya: String? = MyApp.getInstance().resources.getString(R.string.lbl_adithya)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHowdoyoufeel: String? =
      MyApp.getInstance().resources.getString(R.string.msg_how_do_you_feel)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtServicesOffere: String? =
      MyApp.getInstance().resources.getString(R.string.msg_services_offere)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupthreeValue: String? = null
)
