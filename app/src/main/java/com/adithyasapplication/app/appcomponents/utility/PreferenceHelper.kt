package com.adithyasapplication.app.appcomponents.utility

import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.adithyasapplication.app.R
import com.adithyasapplication.app.appcomponents.di.MyApp
import kotlin.String

class PreferenceHelper {
  private val masterKeyAlias: String = createGetMasterKey()

  private val sharedPreference: SharedPreferences = EncryptedSharedPreferences.create(
                                                       
                      MyApp.getInstance().resources.getString(R.string.app_name),
                                                        masterKeyAlias,
                                                        MyApp.getInstance().applicationContext,
                                                       
                      EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                                                       
                            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                                                    )

  /**
   * Creates or gets the master key provided,
   *                                   The encryption scheme is required fields to ensure that the
   * type
   *     of
   *                 encryption
   *                     used
   *                         is
   *                             clear to developers.
   *                                  
   *                                   @return the string value of encrypted key
   */
  private fun createGetMasterKey(): String = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

  fun setName(paramValue: String?) {
    with(sharedPreference.edit()) {
      this.putString("name", paramValue!!)
      apply()
    }
  }

  fun getName(): String? {
    with(sharedPreference) {
      var result = getString("name", null)
      return result
    }
  }

  fun setEmail(paramValue: String?) {
    with(sharedPreference.edit()) {
      this.putString("email", paramValue!!)
      apply()
    }
  }

  fun getEmail(): String? {
    with(sharedPreference) {
      var result = getString("email", null)
      return result
    }
  }

  fun setPhonenumber(paramValue: String?) {
    with(sharedPreference.edit()) {
      this.putString("phonenumber", paramValue!!)
      apply()
    }
  }

  fun getPhonenumber(): String? {
    with(sharedPreference) {
      var result = getString("phonenumber", null)
      return result
    }
  }

  fun setPassword(paramValue: String?) {
    with(sharedPreference.edit()) {
      this.putString("password", paramValue!!)
      apply()
    }
  }

  fun getPassword(): String? {
    with(sharedPreference) {
      var result = getString("password", null)
      return result
    }
  }
}
