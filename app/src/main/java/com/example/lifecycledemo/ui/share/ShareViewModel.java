package com.example.lifecycledemo.ui.share;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

/**
 * Created by lixiaoming on 2018/4/28.
 */

public class ShareViewModel extends ViewModel {
    private static final String TAG = "lxm";
    private MutableLiveData<String> mNameLiveData;

    public LiveData<String> getName() {
        if (mNameLiveData == null) {
            mNameLiveData = new MutableLiveData<>();
        }
        return mNameLiveData;
    }

    public void setName(String name) {
        if (mNameLiveData != null) {
            Log.i(TAG, "setName: " + name);
            mNameLiveData.setValue(name);
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mNameLiveData = null;
    }
}
