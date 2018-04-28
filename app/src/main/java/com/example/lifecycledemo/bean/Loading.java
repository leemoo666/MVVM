package com.example.lifecycledemo.bean;

/**
 * Created by lixiaoming on 2018/4/27.
 */

public class Loading {
    private boolean isLoading = false;

    public Loading() {
    }

    public Loading(boolean isLoading) {
        this.isLoading = isLoading;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public Loading setLoading(boolean loading) {
        isLoading = loading;
        return this;
    }
}
