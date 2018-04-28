package com.example.lifecycledemo.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.lifecycledemo.base.BaseViewModel;
import com.example.lifecycledemo.bean.User;

/**
 * Created by lixiaoming on 2018/4/27.
 */

public class MainViewModel extends BaseViewModel {

    private MutableLiveData<User> userLiveData = new MutableLiveData<User>();

    private User user;

    public MainViewModel() {
        Log.i("lxm","init...");
        this.user = new User();
    }

    public LiveData<User> getUserLiveData() {

        // TODO: 2018/4/28 如果要实现不同的fragment之间数据通信，切记注掉下面的代码，如果不注掉，会认为userLiveData是不同的对象
//        userLiveData = new MutableLiveData<User>();
        user = new User();
        return userLiveData;
    }

    public void setUsername(String username) {
        userLiveData.setValue(user.setName(username));
    }

    public void setUserAge(int age) {
        userLiveData.setValue(user.setAge(age));
    }


    public void request() {
        Log.i("lxm","request");
        setLoading(true);

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                httpRequest("", new CallBack() {
                    @Override
                    public void success() {
//                        Log.i("lxm","success");
                        setLoading(false);
                        setUsername("网络名字：大梅");
                    }

                    @Override
                    public void failure() {
//                        Log.i("lxm","failure");
                        setLoading(false);

                    }
                });
            }
        }, 5000);
    }

    private void httpRequest(String params, CallBack callBack) {
        if (true) {
            callBack.success();
        } else {
            callBack.failure();
        }
    }

    interface CallBack {
        void success();

        void failure();
    }
}
