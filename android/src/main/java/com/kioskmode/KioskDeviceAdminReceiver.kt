package com.kioskmode

import android.app.admin.DeviceAdminReceiver
import android.content.Context
import android.content.Intent

class KioskDeviceAdminReceiver : DeviceAdminReceiver() {
    override fun onEnabled(context: Context, intent: Intent) {
        super.onEnabled(context, intent)
        // Ativado como administrador do dispositivo
    }

    override fun onDisabled(context: Context, intent: Intent) {
        super.onDisabled(context, intent)
        // Removido como administrador do dispositivo
    }
}
