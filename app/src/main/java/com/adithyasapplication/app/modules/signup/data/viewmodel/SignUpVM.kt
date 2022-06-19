package com.adithyasapplication.app.modules.signup.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adithyasapplication.app.appcomponents.utility.PreferenceHelper
import com.adithyasapplication.app.modules.signup.`data`.model.SignUpModel
import com.adithyasapplication.app.network.models.createregister.CreateRegisterRequest
import com.adithyasapplication.app.network.models.createregister.CreateRegisterResponse
import com.adithyasapplication.app.network.repository.NetworkRepository
import com.adithyasapplication.app.network.resources.Response
import kotlin.Boolean
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class SignUpVM : ViewModel(), KoinComponent {
  val signUpModel: MutableLiveData<SignUpModel> = MutableLiveData(SignUpModel())

  var navArguments: Bundle? = null

  val progressLiveData: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

  private val networkRepository: NetworkRepository by inject()

  val createRegisterLiveData: MutableLiveData<Response<CreateRegisterResponse>> =
      MutableLiveData<Response<CreateRegisterResponse>>()

  private val prefs: PreferenceHelper by inject()

  fun onClickBtnSignUp() {
    viewModelScope.launch {
      progressLiveData.postValue(true)
      createRegisterLiveData.postValue(
      networkRepository.createRegister(
      contentType = """application/json""",
          createRegisterRequest = CreateRegisterRequest(
          password = signUpModel.value?.etFrame21Value,
          name = signUpModel.value?.etFrame16Value,
          email = signUpModel.value?.etFrame18Value,
          username = signUpModel.value?.etFrame20Value)
      )
      )
      progressLiveData.postValue(false)
    }
  }

  fun bindCreateRegisterResponse(response: CreateRegisterResponse) {
    val signUpModelValue = signUpModel.value ?:SignUpModel()
    prefs.setName(response.data?.name)
    prefs.setEmail(response.data?.email)
    prefs.setPhonenumber(response.data?.username)
    prefs.setPassword(response.data?.password)
    signUpModel.value = signUpModelValue
  }
}
