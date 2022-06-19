package com.adithyasapplication.app.modules.appnavigation.ui

import androidx.activity.viewModels
import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.base.BaseActivity
import com.adithyasapplication.app.databinding.ActivityAppNavigationBinding
import com.adithyasapplication.app.modules.appnavigation.`data`.viewmodel.AppNavigationVM
import com.adithyasapplication.app.modules.appointments.ui.AppointmentsActivity
import com.adithyasapplication.app.modules.generalhealth.ui.GeneralHealthActivity
import com.adithyasapplication.app.modules.home.ui.HomeActivity
import com.adithyasapplication.app.modules.letsgetstarted.ui.LetsGetStartedActivity
import com.adithyasapplication.app.modules.payments.ui.PaymentsActivity
import com.adithyasapplication.app.modules.signin.ui.SignInActivity
import com.adithyasapplication.app.modules.signup.ui.SignUpActivity
import com.adithyasapplication.app.modules.splashscreen.ui.SplashScreenActivity
import kotlin.String
import kotlin.Unit

class AppNavigationActivity :
    BaseActivity<ActivityAppNavigationBinding>(R.layout.activity_app_navigation) {
  private val viewModel: AppNavigationVM by viewModels<AppNavigationVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.appNavigationVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearPayments.setOnClickListener {
      val destIntent = PaymentsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearGeneralHealth.setOnClickListener {
      val destIntent = GeneralHealthActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearSignUp.setOnClickListener {
      val destIntent = SignUpActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearLetsGetStarted.setOnClickListener {
      val destIntent = LetsGetStartedActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearHome.setOnClickListener {
      val destIntent = HomeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearSplashScreen.setOnClickListener {
      val destIntent = SplashScreenActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearAppointments.setOnClickListener {
      val destIntent = AppointmentsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearSignIn.setOnClickListener {
      val destIntent = SignInActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "APP_NAVIGATION_ACTIVITY"
  }
}
