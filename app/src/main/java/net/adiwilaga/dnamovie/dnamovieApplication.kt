package net.adiwilaga.dnamovie

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDexApplication
import android.util.Log
import android.content.pm.PackageManager
import android.util.Base64
import java.security.MessageDigest


class dnamovieApplication:MultiDexApplication(){

    init {
        instance = this

    }
    companion object {
        private var instance: dnamovieApplication? = null
        var APIKEY="bccdbaa248b07ed46f71ab92d7925bcf"
        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

    }


}