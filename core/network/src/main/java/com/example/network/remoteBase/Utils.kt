package com.example.network.remoteBase

import android.util.Log
import com.example.marvelcharacter.core.network.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object Utils {

    val ts = Timestamp(System.currentTimeMillis()).time.toString()

    fun hash(): String {
        Log.d("xxx ts" , "$ts")
        val input = "$ts${BuildConfig.PRIVATE_KEY}${BuildConfig.API_KEY}"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}