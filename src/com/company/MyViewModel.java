package com.company;

import java.util.Observable;
import java.util.Observer;

public class MyViewModel {

    private MyObservable<String> messageObservable = new MyObservable<>("");
    private Model model;
    public static final String EMPTY = "EMPTY";
    public static final String LOADING = "LOADING";
    public static final String FETCHED = "FETCHED";
    public static final String ERROR = "ERROR";


    public MyViewModel(Model model){
        this.model = model;
    }

    public void onInit(){
        messageObservable.setValue(LOADING);
        this.model.getValue(new Model.ValueListener() {
            @Override
            public void onFetched(String message) {
                messageObservable.setValue(FETCHED);
            }

            @Override
            public void onError(Throwable throwable) {
                messageObservable.setValue(ERROR);
            }
        });
    }

    public MyObservable<String> getMessageObservable() {
        return messageObservable;
    }
}
