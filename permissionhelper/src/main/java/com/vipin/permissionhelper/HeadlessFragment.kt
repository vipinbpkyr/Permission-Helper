package com.vipin.permissionhelper

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * A Headless [Fragment] subclass.
 *
 */
class HeadlessFragment : Fragment() {
    private val PERMISSION_REQUEST_CODE = 16
    private val taskImpl: PermissionTaskImpl<MutableList<Pair<String, Int>>> by lazy { PermissionTaskImpl<MutableList<Pair<String, Int>>>() }
    private val mutableLiveData  = MutableLiveData<Array<String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mutableLiveData.observe(this,  Observer {
            requestPermissions(
                it,
                PERMISSION_REQUEST_CODE
            )
        }

        )
    }

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

    fun requestPermissionInternal(arrayOf: Array<String>): PermissionTaskImpl<MutableList<Pair<String, Int>>> {

        mutableLiveData.value = arrayOf
        return taskImpl
    }
}