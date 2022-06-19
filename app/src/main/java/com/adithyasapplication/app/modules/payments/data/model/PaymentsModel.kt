package com.adithyasapplication.app.modules.payments.`data`.model

import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class PaymentsModel(
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
  var txtGeneralHealth: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_general_health)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt96: String? = MyApp.getInstance().resources.getString(R.string.lbl_96)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt100: String? = MyApp.getInstance().resources.getString(R.string.lbl_100)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtYourHealthizee: String? =
      MyApp.getInstance().resources.getString(R.string.msg_your_healthize)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtWeight: String? = MyApp.getInstance().resources.getString(R.string.lbl_weight)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt97: String? = MyApp.getInstance().resources.getString(R.string.lbl_96)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeight: String? = MyApp.getInstance().resources.getString(R.string.lbl_height)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt196: String? = MyApp.getInstance().resources.getString(R.string.lbl_196)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBloodPressure: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_blood_pressure)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt120: String? = MyApp.getInstance().resources.getString(R.string.lbl_120)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt80: String? = MyApp.getInstance().resources.getString(R.string.lbl_80)

)
