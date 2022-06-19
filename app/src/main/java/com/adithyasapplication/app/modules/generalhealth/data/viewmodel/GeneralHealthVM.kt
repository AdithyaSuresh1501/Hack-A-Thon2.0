package com.adithyasapplication.app.modules.generalhealth.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adithyasapplication.app.modules.generalhealth.`data`.model.GeneralHealth1RowModel
import com.adithyasapplication.app.modules.generalhealth.`data`.model.GeneralHealthModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class GeneralHealthVM : ViewModel(), KoinComponent {
  val generalHealthModel: MutableLiveData<GeneralHealthModel> =
      MutableLiveData(GeneralHealthModel())

  var navArguments: Bundle? = null

  val recyclerGeneralHealthList: MutableLiveData<MutableList<GeneralHealth1RowModel>> =
      MutableLiveData(mutableListOf())
}
