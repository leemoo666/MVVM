package com.example.lifecycledemo.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.lifecycledemo.bean.Loading;
import com.example.lifecycledemo.bean.User;

/**
 * Created by lixiaoming on 2018/4/27.
 */

public class LoadingViewModel extends AndroidViewModel {

    public void showLoading() {

    }

    public void dismissLoading() {

    }

    private MutableLiveData<Loading> loadingLiveData = new MutableLiveData<>();

    private Loading loading;

    public LoadingViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Loading> getLoadingLiveData() {
        loadingLiveData = new MutableLiveData<Loading>();
        loading = new Loading();
        return loadingLiveData;
    }

    public void setLoading(boolean isLoading) {
        loadingLiveData.setValue(loading.setLoading(isLoading));
    }

}
