package com.kioskmode

import android.app.Activity
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise

class KioskModeModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "KioskMode"
    }

    private val devicePolicyManager: DevicePolicyManager by lazy {
        reactContext.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
    }
    private val componentName: ComponentName by lazy {
        ComponentName(reactContext, KioskDeviceAdminReceiver::class.java)
    }

    @ReactMethod
    fun startKioskMode(promise: Promise) {
        val activity = currentActivity
        if (activity == null) {
            promise.reject("ACTIVITY_NOT_AVAILABLE", "A atividade atual não está disponível")
            return
        }

        if (devicePolicyManager.isAdminActive(componentName)) {
            devicePolicyManager.setLockTaskPackages(componentName, arrayOf(reactContext.packageName))
            activity.startLockTask()
            promise.resolve(true)
        } else {
            promise.reject("NOT_DEVICE_ADMIN", "O aplicativo não é administrador do dispositivo")
        }
    }

    @ReactMethod
    fun stopKioskMode(promise: Promise) {
        val activity = currentActivity
        if (activity == null) {
            promise.reject("ACTIVITY_NOT_AVAILABLE", "A atividade atual não está disponível")
            return
        }

        try {
            activity.stopLockTask()
            promise.resolve(true)
        } catch (e: Exception) {
            promise.reject("ERROR_STOPPING_KIOSK", "Erro ao parar o modo quiosque", e)
        }
    }
}
