package com.company;

public class MyObservable<X> {

    private X currentValue;
    public interface MyObserver<M> {
        void onChanged(M x);
    }
    private MyObserver<X> observer;

    public MyObservable(X value){
        this.currentValue = value;
    }

    public void setObserver(MyObserver<X> observer){
        this.observer = observer;
    }

    public void setValue(X value){
        this.currentValue = value;
        if(observer != null){
            observer.onChanged(this.currentValue);
        }
    }

    public X getCurrentValue() {
        return currentValue;
    }
}
