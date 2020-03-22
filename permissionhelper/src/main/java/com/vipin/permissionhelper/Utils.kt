package com.vipin.permissionhelper

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

    val taskImpl: PermissionTaskImpl<MutableList<Pair<String, Int>>>
    var counterState: HeadlessFragment? = fragmentManager
        ?.findFragmentByTag("headless_fragment") as HeadlessFragment?

    if (counterState == null) {
        counterState = HeadlessFragment()
        counterState.let {
            fragmentManager?.beginTransaction()
                ?.add(it, "headless_fragment")?.commit()
        }
    }
    taskImpl = counterState.requestPermissionInternal(arrayOf)

    return taskImpl
}