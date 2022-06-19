package com.adithyasapplication.app.modules.generalhealth.`data`.model

import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class GeneralHealthModel(
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
  var txtPayments: String? = MyApp.getInstance().resources.getString(R.string.lbl_payments)

)
