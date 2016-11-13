package com.eworkbandung.nowdb.example.service;

/**
 * Created by Seta on 9/3/16.
 */
public interface MyCallBack<T> {
    void onSuccess(T response);
    void onError(String header, String message);
}
