# permission-helper

### How to use
```
fun checkRequiredPermissions() {
        // Protect your code with this block that requires permission
        permissionManager.requiresPermission(
            Permission.LOCATION,
            requestPermissions = { permission, _ ->
                // Ask to request Permission
            },
            onPermissionGranted = {
                onRequiredPermissionReceived()
            })
    }

fun onRequestPermissionResult(requestCode: Int) {
        if (requestCode == Permission.LOCATION.requestCode) {
            permissionManager.checkRequestAccess(Permission.LOCATION, 
                onPermissionGranted = {
                // Do things when permission is granted
            }, onPermissionRejected = {
                // Show Permission required dialog
            })
        }
    }
```