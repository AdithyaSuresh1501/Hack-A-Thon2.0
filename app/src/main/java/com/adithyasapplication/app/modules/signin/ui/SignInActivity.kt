package com.adithyasapplication.app.modules.signin.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.base.BaseActivity
import com.adithyasapplication.app.appcomponents.di.MyApp
import com.adithyasapplication.app.appcomponents.utility.PreferenceHelper
import com.adithyasapplication.app.databinding.ActivitySignInBinding
import com.adithyasapplication.app.extensions.NoInternetConnection
import com.adithyasapplication.app.extensions.hideKeyboard
import com.adithyasapplication.app.extensions.isJSONObject
import com.adithyasapplication.app.extensions.isNumeric
import com.adithyasapplication.app.extensions.isValidPassword
import com.adithyasapplication.app.extensions.showProgressDialog
import com.adithyasapplication.app.modules.home.ui.HomeActivity
import com.adithyasapplication.app.modules.signin.`data`.viewmodel.SignInVM
import com.adithyasapplication.app.modules.signup.ui.SignUpActivity
import com.adithyasapplication.app.network.models.createregister.CreateRegisterResponse
import com.adithyasapplication.app.network.resources.ErrorResponse
import com.adithyasapplication.app.network.resources.SuccessResponse
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception
import kotlin.String
import kotlin.Unit
import org.json.JSONObject
import org.koin.android.ext.android.inject
import retrofit2.HttpException

class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
  private val viewModel: SignInVM by viewModels<SignInVM>()

  private val prefs: PreferenceHelper by inject()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signInVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnNext.setOnClickListener {
      if(
      viewModel.signInModel.value?.etFrame20Value.
      isNumeric(true) == true
      && viewModel.signInModel.value?.etFrame21Value.
      isValidPassword(true) == true) {
        this@SignInActivity.hideKeyboard()
        viewModel.onClickBtnNext()
      }
    }
    binding.btnSignUp.setOnClickListener {
      val destIntent = SignUpActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  override fun addObservers(): Unit {
    var progressDialog : AlertDialog? = null
    viewModel.progressLiveData.observe(this@SignInActivity) {
      if(it) {
        progressDialog?.dismiss()
        progressDialog = null
        progressDialog = this@SignInActivity.showProgressDialog()
      } else {
        progressDialog?.dismiss()
      }
    }
    viewModel.createRegisterLiveData.observe(this@SignInActivity) {
      if(it is SuccessResponse) {
        val response = it.getContentIfNotHandled()
        onSuccessCreateRegister(it)
      } else if(it is ErrorResponse) {
        onErrorCreateRegister(it.data ?:Exception())
      }
    }
  }

  private fun onSuccessCreateRegister(response: SuccessResponse<CreateRegisterResponse>): Unit {
    viewModel.bindCreateRegisterResponse(response.data)
    if(
    prefs.getPhonenumber() ==
    viewModel.createRegisterLiveData.value?.getSuccessResponse()?.data?.username
    && prefs.getPassword() ==
    viewModel.createRegisterLiveData.value?.getSuccessResponse()?.data?.password
    ) {
      onSuccessCreateRegisterCondition()
    }
    else {
      onSuccessCreateRegisterCondition1()
    }
  }

  private fun onErrorCreateRegister(exception: Exception): Unit {
    when(exception) {
      is NoInternetConnection -> {
        Snackbar.make(binding.root, exception.message?:"", Snackbar.LENGTH_LONG).show()
      }
      is HttpException -> {
        val errorBody = exception.response()?.errorBody()?.string()
        val errorObject = if (errorBody != null  && errorBody.isJSONObject()) JSONObject(errorBody)
        else JSONObject()
        val errMessage = if(!errorObject.optString("message").isNullOrEmpty()) {
          errorObject.optString("message").toString()
        } else {
          exception.response()?.message()?:""
        }
        Snackbar.make(binding.root, errMessage, Snackbar.LENGTH_LONG).show()
      }
    }
  }

  private fun onSuccessCreateRegisterCondition(): Unit {
    val destIntent = HomeActivity.getIntent(this, null)
    startActivity(destIntent)
  }

  private fun onSuccessCreateRegisterCondition1(): Unit {
    Snackbar.make(binding.root, MyApp.getInstance().getString(R.string.msg_please_try_that_again),
    Snackbar.LENGTH_LONG).show()
  }

  companion object {
    const val TAG: String = "SIGN_IN_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignInActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
