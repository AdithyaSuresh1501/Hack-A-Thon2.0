package com.adithyasapplication.app.modules.letsgetstarted.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.base.BaseActivity
import com.adithyasapplication.app.databinding.ActivityLetsGetStartedBinding
import com.adithyasapplication.app.modules.letsgetstarted.`data`.viewmodel.LetsGetStartedVM
import com.adithyasapplication.app.modules.signup.ui.SignUpActivity
import kotlin.String
import kotlin.Unit

class LetsGetStartedActivity :
    BaseActivity<ActivityLetsGetStartedBinding>(R.layout.activity_lets_get_started) {
  private val viewModel: LetsGetStartedVM by viewModels<LetsGetStartedVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.letsGetStartedVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnGetStarted.setOnClickListener {
      val destIntent = SignUpActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "LETS_GET_STARTED_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, LetsGetStartedActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
