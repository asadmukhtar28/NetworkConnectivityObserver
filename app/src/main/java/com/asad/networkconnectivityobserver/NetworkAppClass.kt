package com.asad.networkconnectivityobserver

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.asad.networkconnectivityobserver.utils.network.NetworkConnectivityObserver
import com.asad.networkconnectivityobserver.utils.network.NetworkConnectivityObserverImpl
import com.asad.networkconnectivityobserver.utils.network.NetworkStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NetworkAppClass : Application() {

    override fun onCreate() {
        super.onCreate()

        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            NetworkConnectivityObserverImpl(this@NetworkAppClass).observer().collect{state->
                when(state){
                    NetworkStatus.Disconnected-> internetConnectivityStatus.postValue("Disconnected")
                    NetworkStatus.Unavailable-> internetConnectivityStatus.postValue("Unavailable")
                    NetworkStatus.Connected-> internetConnectivityStatus.postValue("Connected")
                }

            }
        }
    }

    companion object {
        val internetConnectivityStatus = MutableLiveData<String>()
    }
}