package com.example.lifecycledemo.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.lifecycledemo.bean.Loading;

/**
 * Created by lixiaoming on 2018/4/28.
 */

public class BaseViewModel extends ViewModel {

    /*******************是否正在加载*********************/
    private MutableLiveData<Loading> loadingLiveData = new MutableLiveData<>();

    private Loading loading = new Loading();

    public LiveData<Loading> getLoadingLiveData() {
        loadingLiveData = new MutableLiveData<Loading>();
        loading = new Loading();
        return loadingLiveData;
    }

    public void setLoading(boolean isLoading) {
        loadingLiveData.setValue(loading.setLoading(isLoading));
    }

    /************************************************/
}
