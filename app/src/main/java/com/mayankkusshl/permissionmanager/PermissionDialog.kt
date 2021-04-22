package com.mayankkusshl.permissionmanager

import androidx.fragment.app.DialogFragment

class PermissionDialog : DialogFragment() {

    companion object {
        fun getInstance(dialogBean: PermissionDialogBean): PermissionDialog {
            return PermissionDialog()
        }
    }
}