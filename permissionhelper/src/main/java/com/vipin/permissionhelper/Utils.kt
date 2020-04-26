package com.vipin.permissionhelper

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import kotlinx.coroutines.Deferred


fun <T> PermissionTask<T>.asDeferred(): Deferred<T> {
    val deferred = kotlinx.coroutines.CompletableDeferred<T>()

    deferred.invokeOnCompletion {
        if (deferred.isCancelled) {
            // optional, handle coroutine cancellation however you'd like here
        }
    }

    this.addOnSuccessListener { result -> deferred.complete(result) }
    this.addOnFailureListener { exception -> deferred.completeExceptionally(exception) }

    return deferred
}

fun Fragment.requestPermissionAsync(arrayOf: Array<String>): PermissionTask<MutableList<Pair<String, Int>>>{

    val taskImpl: PermissionTask<MutableList<Pair<String, Int>>>
    var counterState: HeadlessFragment? = fragmentManager
        ?.findFragmentByTag("headless_fragment") as HeadlessFragment?

    if (counterState == null) {
        counterState = HeadlessFragment()
        counterState.let {
            fragmentManager?.beginTransaction()
                ?.addToBackStack(null)
                ?.add(it, "headless_fragment")?.commit()
        }
    }
    taskImpl = counterState.requestPermissionInternal(arrayOf)

    return taskImpl
}

fun Fragment.showRationale(permission: String)  =
     ActivityCompat.shouldShowRequestPermissionRationale(
        requireActivity(),
         permission
    )

fun Fragment.goToDetailsSettings() {
    Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:${requireActivity().packageName}")).apply {
        addCategory(Intent.CATEGORY_DEFAULT)
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }.also { intent ->
        startActivity(intent)
    }
}