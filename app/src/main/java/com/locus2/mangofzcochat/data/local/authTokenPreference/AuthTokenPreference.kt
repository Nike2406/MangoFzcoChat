package com.locus2.mangofzcochat.data.local.authTokenPreference

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.locus2.mangofzcochat.core.utils.constant.EMPTY_STRING
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AuthTokenPreference @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        AUTH_TOKEN_PREFERENCE,
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )


    fun saveAccessToken(token: String) {
        sharedPreferences.edit()
            .putString(ACCESS_TOKEN, token)
            .apply()
    }

    fun getAccessToken(): String {
        return sharedPreferences.getString(ACCESS_TOKEN, EMPTY_STRING).orEmpty()
    }

    fun saveRefreshToken(token: String) {
        sharedPreferences.edit()
            .putString(REFRESH_TOKEN, token)
            .apply()
    }

    fun getRefreshToken(): String {
        return sharedPreferences.getString(REFRESH_TOKEN, EMPTY_STRING).orEmpty()
    }

    fun deleteTokens() {
        sharedPreferences.edit().clear().apply()
    }


    companion object {

        private const val AUTH_TOKEN_PREFERENCE = "auth_tokens"
        private const val ACCESS_TOKEN = "access_token"
        private const val REFRESH_TOKEN = "refresh_token"
    }
}
