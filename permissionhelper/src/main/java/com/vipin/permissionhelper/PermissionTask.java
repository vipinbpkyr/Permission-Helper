package com.vipin.permissionhelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class PermissionTask<TResult> {

    public PermissionTask() {
    }

    public abstract boolean isComplete();

    public abstract boolean isSuccessful();

    public abstract boolean isCanceled();

    @Nullable
    public abstract TResult getResult();

    @NonNull
    public abstract PermissionTask<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> var1);
    public abstract PermissionTask<TResult> addOnFailureListener(@NonNull OnFailureListener var1);

}
