package com.codegrace.Saklo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\fj\b\u0012\u0004\u0012\u00020\u0007`\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u001e\u0010\u0017\u001a\u00020\n2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00070\fj\b\u0012\u0004\u0012\u00020\u0007`\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/codegrace/Saklo/remediesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/codegrace/Saklo/remediesAdapter$remediesViewHolder;", "context", "Landroid/content/Context;", "remediesList", "", "Lcom/codegrace/Saklo/RemediesModel;", "(Landroid/content/Context;Ljava/util/List;)V", "addItems", "", "items", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "searchDataList", "searchList", "remediesViewHolder", "app_debug"})
public final class remediesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.codegrace.Saklo.remediesAdapter.remediesViewHolder> {
    private final android.content.Context context = null;
    private java.util.List<com.codegrace.Saklo.RemediesModel> remediesList;
    
    public remediesAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.codegrace.Saklo.RemediesModel> remediesList) {
        super();
    }
    
    public final void addItems(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.codegrace.Saklo.RemediesModel> items) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.codegrace.Saklo.remediesAdapter.remediesViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.codegrace.Saklo.remediesAdapter.remediesViewHolder holder, int position) {
    }
    
    public final void searchDataList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.codegrace.Saklo.RemediesModel> searchList) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0004\u00a8\u0006\u0015"}, d2 = {"Lcom/codegrace/Saklo/remediesAdapter$remediesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "id", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getId", "()Landroid/widget/TextView;", "setId", "(Landroid/widget/TextView;)V", "nameCommon", "getNameCommon", "setNameCommon", "nameScientific", "getNameScientific", "setNameScientific", "getView", "()Landroid/view/View;", "setView", "app_debug"})
    public static final class remediesViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private android.view.View view;
        private android.widget.TextView id;
        private android.widget.TextView nameCommon;
        private android.widget.TextView nameScientific;
        
        public remediesViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.view.View getView() {
            return null;
        }
        
        public final void setView(@org.jetbrains.annotations.NotNull
        android.view.View p0) {
        }
        
        public final android.widget.TextView getId() {
            return null;
        }
        
        public final void setId(android.widget.TextView p0) {
        }
        
        public final android.widget.TextView getNameCommon() {
            return null;
        }
        
        public final void setNameCommon(android.widget.TextView p0) {
        }
        
        public final android.widget.TextView getNameScientific() {
            return null;
        }
        
        public final void setNameScientific(android.widget.TextView p0) {
        }
    }
}