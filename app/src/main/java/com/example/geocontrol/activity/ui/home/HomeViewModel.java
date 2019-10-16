package com.example.geocontrol.activity.ui.home;

import android.app.Notification;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    public Notification.Action action;

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Bem-vindo");
    }

    public LiveData<String> getText() {
        return mText;
    }
}