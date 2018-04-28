package com.example.lifecycledemo.base;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.lifecycledemo.base.BaseViewModel;
import com.example.lifecycledemo.bean.Loading;

/**
 * Created by lixiaoming on 2018/4/28.
 */

public abstract class BaseActivity<T extends BaseViewModel> extends AppCompatActivity {

    T baseViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseViewModel = createViewModel();
        baseViewModel.getLoadingLiveData().observe(this, new Observer<Loading>() {
            @Override
            public void onChanged(@Nullable Loading loading) {
                Log.i("lxm", "base");
                if (loading.isLoading()) {
                    showLoading();
                } else {
                    dismissLoading();
                }
            }
        });
    }

    public abstract T createViewModel();


    public T getViewModel() {
        return baseViewModel;
    }

    public void showLoading() {
        Log.i("lxm", "showLoading");
    }

    public void dismissLoading() {
        Log.i("lxm", "dismissLoading");

    }
}
