package com.company;

public class MyViewModel2 implements Model.ValueListener {

    private MyObservable<String> messageObservable = new MyObservable<>("");
    private Model model;
    public static final String EMPTY = "EMPTY";
    public static final String LOADING = "LOADING";
    public static final String FETCHED = "FETCHED";
    public static final String ERROR = "ERROR";
    public ValueListenerComponent valueListenerComponent;


    public MyViewModel2(Model model, ValueListenerComponent valueListenerComponent){
        this.model = model;
        this.valueListenerComponent = valueListenerComponent;
    }

    public void onInit(){
        messageObservable.setValue(LOADING);
        valueListenerComponent.toDestination(this);
        this.model.getValue(valueListenerComponent);
    }

    public MyObservable<String> getMessageObservable() {
        return messageObservable;
    }

    @Override
    public void onFetched(String message) {
        messageObservable.setValue(FETCHED);
    }

    @Override
    public void onError(Throwable throwable) {
        messageObservable.setValue(ERROR);
    }
}
