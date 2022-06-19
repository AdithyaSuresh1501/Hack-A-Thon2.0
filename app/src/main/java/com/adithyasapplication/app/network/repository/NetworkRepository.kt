package com.adithyasapplication.app.network.repository

import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.di.MyApp
import com.adithyasapplication.app.extensions.NoInternetConnection
import com.adithyasapplication.app.extensions.isOnline
import com.adithyasapplication.app.network.RetrofitServices
import com.adithyasapplication.app.network.models.createregister.CreateRegisterRequest
import com.adithyasapplication.app.network.models.createregister.CreateRegisterResponse
import com.adithyasapplication.app.network.resources.ErrorResponse
import com.adithyasapplication.app.network.resources.Response
import com.adithyasapplication.app.network.resources.SuccessResponse
import java.lang.Exception
import kotlin.String
import org.koin.core.KoinComponent
import org.koin.core.inject

class NetworkRepository : KoinComponent {
  private val retrofitServices: RetrofitServices by inject()

  private val errorMessage: String = "Something went wrong."

  suspend fun createRegister(contentType: String?, createRegisterRequest: CreateRegisterRequest?):
      Response<CreateRegisterResponse> = try {
    val isOnline = MyApp.getInstance().isOnline()
    if(isOnline) {
      SuccessResponse(retrofitServices.createRegister(contentType, createRegisterRequest))
    } else {
      val internetException =
          NoInternetConnection(MyApp.getInstance().getString(R.string.no_internet_connection))
      ErrorResponse(internetException.message ?:errorMessage, internetException)
    }
  } catch(e:Exception) {
    e.printStackTrace()
    ErrorResponse(e.message ?:errorMessage, e)
  }
}
