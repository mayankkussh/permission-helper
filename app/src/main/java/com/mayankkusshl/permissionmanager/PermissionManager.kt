package com.mayankkusshl.permissionmanager

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

class PermissionManager constructor(val context: Context) {

    fun requiresPermission(
        permission: Permission,
        requestPermissions: (permission: Permission, permissionDialog: PermissionDialog) -> Unit,
        onPermissionGranted: () -> Unit
    ) {
        if (isPermissionGranted(permission)) {
            onPermissionGranted.invoke()
        } else {

            requestPermissions.invoke(
                permission,
                PermissionDialogFactory.getPrePermissionDialog(permission)
            )
        }
    }

    fun checkRequestAccess(
        permission: Permission,
        onPermissionGranted: () -> Unit,
        onPermissionRejected: ((permissionDialog: PermissionDialog) -> Unit)? = null
    ) {
        if (isPermissionGranted(permission)) {

            onPermissionGranted.invoke()
        } else {

            onPermissionRejected?.invoke(
                PermissionDialogFactory.getPostPermissionDialog(permission)
            )
        }
    }

    private fun isPermissionGranted(permission: Permission): Boolean {
        permission.array.forEach {
            if (ContextCompat.checkSelfPermission(
                    context,
                    it
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return false
            }
        }
        return true
    }

}