package com.codegrace.Saklo.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u001cj\b\u0012\u0004\u0012\u00020\u000e`\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\'"}, d2 = {"Lcom/codegrace/Saklo/activities/DrugsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/codegrace/Saklo/DrugsAdapter$OnItemClickListener;", "()V", "adapter", "Lcom/codegrace/Saklo/DrugsAdapter;", "bottomNav", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "getBottomNav", "()Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "setBottomNav", "(Lcom/google/android/material/bottomnavigation/BottomNavigationView;)V", "drugsList", "", "Lcom/codegrace/Saklo/DrugsModel;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "searchView", "Landroidx/appcompat/widget/SearchView;", "sqLiteHelper", "Lcom/codegrace/Saklo/DrugsSQLiteHelper;", "getSqLiteHelper", "()Lcom/codegrace/Saklo/DrugsSQLiteHelper;", "setSqLiteHelper", "(Lcom/codegrace/Saklo/DrugsSQLiteHelper;)V", "changeStatusBarTextColor", "", "getDrugs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "position", "", "searchList", "text", "", "app_debug"})
public final class DrugsActivity extends androidx.appcompat.app.AppCompatActivity implements com.codegrace.Saklo.DrugsAdapter.OnItemClickListener {
    public com.google.android.material.bottomnavigation.BottomNavigationView bottomNav;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private com.codegrace.Saklo.DrugsAdapter adapter;
    public com.codegrace.Saklo.DrugsSQLiteHelper sqLiteHelper;
    private java.util.List<com.codegrace.Saklo.DrugsModel> drugsList;
    private androidx.appcompat.widget.SearchView searchView;
    
    public DrugsActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.material.bottomnavigation.BottomNavigationView getBottomNav() {
        return null;
    }
    
    public final void setBottomNav(@org.jetbrains.annotations.NotNull
    com.google.android.material.bottomnavigation.BottomNavigationView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.codegrace.Saklo.DrugsSQLiteHelper getSqLiteHelper() {
        return null;
    }
    
    public final void setSqLiteHelper(@org.jetbrains.annotations.NotNull
    com.codegrace.Saklo.DrugsSQLiteHelper p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final java.util.ArrayList<com.codegrace.Saklo.DrugsModel> getDrugs() {
        return null;
    }
    
    private final void searchList(java.lang.String text) {
    }
    
    private final void changeStatusBarTextColor() {
    }
    
    @java.lang.Override
    public void onItemClick(int position) {
    }
}