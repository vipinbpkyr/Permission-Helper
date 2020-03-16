package com.vipin.permissionhelper

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