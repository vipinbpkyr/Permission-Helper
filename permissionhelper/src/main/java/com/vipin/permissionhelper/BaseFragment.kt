package com.vipin.permissionhelper

import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {
    private val PERMISSION_REQUEST_CODE = 16
    private val taskImpl: PermissionTaskImpl<Boolean> by lazy { PermissionTaskImpl<Boolean>() }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        taskImpl.listener.onSuccess(true)

    }
    fun requestPermission(arrayOf: Array<String>): PermissionTask<Boolean> {

        requestPermissions(
            arrayOf,
            PERMISSION_REQUEST_CODE
        )

        return taskImpl
    }
    }