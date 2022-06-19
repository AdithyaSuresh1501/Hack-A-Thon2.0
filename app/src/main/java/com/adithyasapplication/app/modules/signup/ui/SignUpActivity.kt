package com.adithyasapplication.app.modules.signup.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.base.BaseActivity
import com.adithyasapplication.app.databinding.ActivitySignUpBinding
import com.adithyasapplication.app.extensions.NoInternetConnection
import com.adithyasapplication.app.extensions.hideKeyboard
import com.adithyasapplication.app.extensions.isJSONObject
import com.adithyasapplication.app.extensions.isText
import com.adithyasapplication.app.extensions.isValidEmail
import com.adithyasapplication.app.extensions.isValidPassword
import com.adithyasapplication.app.extensions.isValidPhone
import com.adithyasapplication.app.extensions.showProgressDialog
import com.adithyasapplication.app.modules.home.ui.HomeActivity
import com.adithyasapplication.app.modules.signin.ui.SignInActivity
import com.adithyasapplication.app.modules.signup.`data`.viewmodel.SignUpVM
import com.adithyasapplication.app.network.models.createregister.CreateRegisterResponse
import com.adithyasapplication.app.network.resources.ErrorResponse
import com.adithyasapplication.app.network.resources.SuccessResponse
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception
import kotlin.Int
import kotlin.String
import kotlin.Unit
import org.json.JSONObject
import retrofit2.HttpException

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
  private val viewModel: SignUpVM by viewModels<SignUpVM>()

  private val REQUEST_CODE_SIGN_IN_ACTIVITY: Int = 807

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUpVM = viewModel
    val destIntent = HomeActivity.getIntent(this, null)
    startActivity(destIntent)
    finish()
  }

  override fun setUpClicks(): Unit {
    binding.btnLogIn.setOnClickListener {
      val destIntent = SignInActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_SIGN_IN_ACTIVITY)
    }
    binding.btnSignUp.setOnClickListener {
      if(
          viewModel.signUpModel.value?.etFrame16Value.
      isText(false) == true
          && viewModel.signUpModel.value?.etFrame18Value.
      isValidEmail(true) == true
          && viewModel.signUpModel.value?.etFrame20Value.
      isValidPhone(true) == true
          && viewModel.signUpModel.value?.etFrame21Value.
      isValidPassword(true) == true) {
        this@SignUpActivity.hideKeyboard()
        viewModel.onClickBtnSignUp()
      }
    }
  }

  override fun addObservers() {
    var progressDialog : AlertDialog? = null
    viewModel.progressLiveData.observe(this@SignUpActivity) {
      if(it) {
        progressDialog?.dismiss()
        progressDialog = null
        progressDialog = this@SignUpActivity.showProgressDialog()
      } else  {
        progressDialog?.dismiss()
      }
    }
    viewModel.createRegisterLiveData.observe(this@SignUpActivity) {
      if(it is SuccessResponse) {
        val response = it.getContentIfNotHandled()
        onSuccessCreateRegister(it)
      } else if(it is ErrorResponse)  {
        onErrorCreateRegister(it.data ?:Exception())
      }
    }
  }

  private fun onSuccessCreateRegister(response: SuccessResponse<CreateRegisterResponse>) {
    viewModel.bindCreateRegisterResponse(response.data)
    val destIntent = SignInActivity.getIntent(this, null)
    startActivityForResult(destIntent, REQUEST_CODE_SIGN_IN_ACTIVITY)
  }

  private fun onErrorCreateRegister(exception: Exception) {
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

  companion object {
    const val TAG: String = "SIGN_UP_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUpActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
