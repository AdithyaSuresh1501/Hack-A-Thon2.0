package com.adithyasapplication.app.modules.appnavigation.`data`.model

import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class AppNavigationModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtAppNavigation: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_app_navigation)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCheckYourAppsUIFromTheBelowDemoScreensOfYourApp: String? =
      MyApp.getInstance().resources.getString(R.string.msg_check_your_app)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHome: String? = MyApp.getInstance().resources.getString(R.string.lbl_home)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSplashScreen: String? = MyApp.getInstance().resources.getString(R.string.lbl_splash_screen)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLetsGetStarted: String? =
      MyApp.getInstance().resources.getString(R.string.msg_lets_get_starte)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSignUp: String? = MyApp.getInstance().resources.getString(R.string.lbl_sign_up3)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSignIn: String? = MyApp.getInstance().resources.getString(R.string.lbl_sign_in)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAppointments: String? = MyApp.getInstance().resources.getString(R.string.lbl_appointments)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPayments: String? = MyApp.getInstance().resources.getString(R.string.lbl_payments)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGeneralHealth: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_general_health)

)
