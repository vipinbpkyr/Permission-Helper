package com.vipin.permissionhelper

import androidx.fragment.app.Fragment
import java.lang.Exception

open class BaseFragment : Fragment() {
    private val PERMISSION_REQUEST_CODE = 16
    private val taskImpl: PermissionTaskImpl<MutableList<Pair<String, Int>>> by lazy { PermissionTaskImpl<MutableList<Pair<String, Int>>>() }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty()) {
                // permission was granted, yay!

                var list = mutableListOf<Pair<String, Int>>()

                for (i in permissions.indices) {
                    list.add(Pair(permissions[i], grantResults[i]))
                }

                taskImpl.successListener.onSuccess(list)
            }else{
                // permission denied, boo! Disable the
                // functionality that depends on this permission.
                taskImpl.failureListener.onFailure(Exception("Permission not granted"))

            }
        }

    }
    fun requestPermission(arrayOf: Array<String>): PermissionTask<MutableList<Pair<String, Int>>> {

        requestPermissions(
            arrayOf,
            PERMISSION_REQUEST_CODE
        )

        return taskImpl
    }
    }