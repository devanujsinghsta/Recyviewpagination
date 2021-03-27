package com.example.anujtest.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.anujtest.home.MainActivity;

public class ViewModel {
    private MainActivity mainActivity;

    public ViewModel(@NonNull Application application) {
        mainActivity= new MainActivity();
    }
    /* public LiveData<ModelData.Datum> getAllUser() {
        return mainActivity.getMutableLiveData();
    }*/
}

