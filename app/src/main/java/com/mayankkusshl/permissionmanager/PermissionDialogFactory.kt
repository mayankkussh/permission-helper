package com.mayankkusshl.permissionmanager

import com.mayankkusshl.permissionmanager.Permission.*

object PermissionDialogFactory {

    fun getPrePermissionDialog(permission: Permission): PermissionDialog {
        val dialogBean = getPrePermissionDialogBean(permission)
        return PermissionDialog.getInstance(dialogBean)
    }

    fun getPostPermissionDialog(permission: Permission): PermissionDialog {
        val dialogBean = getPrePermissionDialogBean(permission)
        return PermissionDialog.getInstance(dialogBean)
    }

    private fun getPostPermissionDialogBean(permission: Permission): PermissionDialogBean {
        return when (permission) {
            STORAGE -> getStoragePrePermissionDialogBean()
            else -> throw IllegalArgumentException()
        }
    }

    private fun getPrePermissionDialogBean(permission: Permission): PermissionDialogBean {
        return when (permission) {
            STORAGE -> getStoragePrePermissionDialogBean()
            OPEN_GALLERY -> getStoragePrePermissionDialogBean()
            OPEN_CAMERA -> getStoragePrePermissionDialogBean()
            LOCATION -> getStoragePrePermissionDialogBean()
            else -> throw IllegalArgumentException()
        }
    }

    private fun getStoragePrePermissionDialogBean(): PermissionDialogBean {
        return PermissionDialogBean("")
    }
}