package com.codegrace.Saklo.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\fH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/codegrace/Saklo/activities/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "mAuthListener", "Lcom/google/firebase/auth/FirebaseAuth$AuthStateListener;", "getMAuthListener", "()Lcom/google/firebase/auth/FirebaseAuth$AuthStateListener;", "setMAuthListener", "(Lcom/google/firebase/auth/FirebaseAuth$AuthStateListener;)V", "changeStatusBarTextColor", "", "handleBackPressed", "user", "Lcom/google/firebase/auth/FirebaseUser;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.google.firebase.auth.FirebaseAuth firebaseAuth;
    @org.jetbrains.annotations.Nullable
    private com.google.firebase.auth.FirebaseAuth.AuthStateListener mAuthListener;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.firebase.auth.FirebaseAuth.AuthStateListener getMAuthListener() {
        return null;
    }
    
    public final void setMAuthListener(@org.jetbrains.annotations.Nullable
    com.google.firebase.auth.FirebaseAuth.AuthStateListener p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    private final void handleBackPressed(com.google.firebase.auth.FirebaseUser user) {
    }
    
    private final void changeStatusBarTextColor() {
    }
}