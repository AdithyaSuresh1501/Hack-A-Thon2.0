package com.adithyasapplication.app.modules.signin.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adithyasapplication.app.modules.signin.`data`.model.SignInModel
import com.adithyasapplication.app.network.models.createregister.CreateRegisterRequest
import com.adithyasapplication.app.network.models.createregister.CreateRegisterResponse
import com.adithyasapplication.app.network.repository.NetworkRepository
import com.adithyasapplication.app.network.resources.Response
import kotlin.Boolean
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class SignInVM : ViewModel(), KoinComponent {
  val signInModel: MutableLiveData<SignInModel> = MutableLiveData(SignInModel())

  var navArguments: Bundle? = null

  val progressLiveData: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

  private val networkRepository: NetworkRepository by inject()

  val createRegisterLiveData: MutableLiveData<Response<CreateRegisterResponse>> =
      MutableLiveData<Response<CreateRegisterResponse>>()

  fun onClickBtnNext() {
    viewModelScope.launch {
      progressLiveData.postValue(true)
      createRegisterLiveData.postValue(
      networkRepository.createRegister(
      contentType = """application/json""",
          createRegisterRequest = CreateRegisterRequest(
          password = signInModel.value?.etFrame21Value,
          username = signInModel.value?.etFrame20Value)
      )
      )
      progressLiveData.postValue(false)
    }
  }

  fun bindCreateRegisterResponse(response: CreateRegisterResponse) {
    val signInModelValue = signInModel.value ?:SignInModel()
    signInModel.value = signInModelValue
  }
}
