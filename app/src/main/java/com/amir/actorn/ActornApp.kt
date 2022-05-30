package com.amir.actorn

import android.app.Application
import com.amir.actorn.data.NetworkDataSource
import com.amir.actorn.repository.AppRepository
import timber.log.Timber

class ActornApp : Application()
{
     lateinit var repository : AppRepository
     override fun onCreate()
     {
          super.onCreate()
          val networkDataSource = NetworkDataSource()
          repository = AppRepository(networkDataSource)
          if (BuildConfig.DEBUG)
          {
               Timber.plant(Timber.DebugTree())
          }
     }
}