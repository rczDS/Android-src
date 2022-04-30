package com.example.tablayout;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class ListViewModel extends ViewModel {
    private static final String LOG_TAG = ListViewModel.class.getSimpleName();

    private final MutableLiveData<String> new_trend = new MutableLiveData<>();

    public LiveData<String> getTrend() {
        Log.d(LOG_TAG, "need: " + new_trend.getValue());
        return new_trend;
    }

    public void setTrend(String change_trend) {
        this.new_trend.setValue(change_trend);
        Log.d(LOG_TAG, "set: " + new_trend.getValue());
    }

}