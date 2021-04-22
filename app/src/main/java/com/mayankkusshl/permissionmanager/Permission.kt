package com.mayankkusshl.permissionmanager

import android.Manifest
import android.Manifest.permission

enum class Permission(val array: Array<String>, val requestCode: Int) {
  STORAGE(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 10004),
  LOCATION(arrayOf(permission.ACCESS_COARSE_LOCATION), 10008),
  OPEN_GALLERY(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 10006),
  OPEN_CAMERA(arrayOf(Manifest.permission.CAMERA), 10007)
}