package com.vipin.permissionhelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PermissionTaskImpl<TResult> extends PermissionTask<TResult> {
    private OnSuccessListener<? super TResult> onSuccessListener;
    private OnFailureListener onFailureListener;
    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public boolean isSuccessful() {
        return false;
    }

    @Override
    public boolean isCanceled() {
        return false;
    }

    @Nullable
    @Override
    public TResult getResult() {
        return null;
    }

    @NonNull
    @Override
    public PermissionTask<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> var1) {
        onSuccessListener = var1;
        return this;
    }

    @Override
    public PermissionTask<TResult> addOnFailureListener(@NonNull OnFailureListener var1) {
        onFailureListener = var1;
        return this;
    }

    public OnSuccessListener<? super TResult> getSuccessListener() {
        return onSuccessListener;
    }

    public OnFailureListener getFailureListener() {
        return onFailureListener;
    }
}
