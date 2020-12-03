package com.company;

public class ValueListenerComponent implements Model.ValueListener {

    private Model.ValueListener destination;

    @Override
    public void onFetched(String message) {
        if(destination != null){
            destination.onFetched(message);
        }
    }

    @Override
    public void onError(Throwable throwable) {
         if(destination != null){
             destination.onError(throwable);
         }
    }


    public void toDestination(Model.ValueListener valueListener){
        this.destination = valueListener;
    }

    public Model.ValueListener getDestination() {
        return destination;
    }
}
