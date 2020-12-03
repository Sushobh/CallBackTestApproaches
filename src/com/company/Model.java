package com.company;

public class Model {

    public interface ValueListener {
        void onFetched(String message);
        void onError(Throwable throwable);
    }


    public void getValue(ValueListener valueListener) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(200);
                    valueListener.onFetched("IntelliJ Idea");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

}
