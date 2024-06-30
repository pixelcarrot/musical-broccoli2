package com.pixelcarrot.broccoli

import android.app.Application
import com.pixelcarrot.broccoli.mock.MockServer
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BroccoliApp : Application() {

    override fun onCreate() {
        super.onCreate()
        MockServer.start(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        MockServer.shutdown()
    }

}
