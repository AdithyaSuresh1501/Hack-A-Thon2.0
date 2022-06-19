package com.adithyasapplication.app.modules.appointments.`data`.model

import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class AppointmentsModel(
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
  var txtYourAppointmen: String? =
      MyApp.getInstance().resources.getString(R.string.msg_your_appointmen)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtUpcoming: String? = MyApp.getInstance().resources.getString(R.string.lbl_upcoming)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSubtitle2: String? = MyApp.getInstance().resources.getString(R.string.lbl_dr_suresh)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPast: String? = MyApp.getInstance().resources.getString(R.string.lbl_past)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtWeburl: String? = MyApp.getInstance().resources.getString(R.string.lbl_dr_ramesh)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtWeburl1: String? = MyApp.getInstance().resources.getString(R.string.lbl_dr_vivek)

)
