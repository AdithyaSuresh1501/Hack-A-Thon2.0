package com.adithyasapplication.app.modules.generalhealth.`data`.model

import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class GeneralHealth1RowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtPaymentSucessf: String? =
      MyApp.getInstance().resources.getString(R.string.msg_payment_sucessf)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtToDrRamesh: String? = MyApp.getInstance().resources.getString(R.string.lbl_to_dr_ramesh)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGenerateInvoic: String? =
      MyApp.getInstance().resources.getString(R.string.msg_generate_invoic)

)
