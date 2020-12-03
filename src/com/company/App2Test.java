package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class App2Test {

    private MyViewModel myViewModel;



    Model model = new Model();

    @BeforeEach
    void setUp() {
        myViewModel = new MyViewModel(model);
    }

    @Test
    void onInit() throws Exception{
        myViewModel.onInit();
        Assertions.assertEquals(MyViewModel.LOADING,myViewModel.getMessageObservable().getCurrentValue());
        Thread.sleep(1000);
        Assertions.assertEquals(MyViewModel.FETCHED,myViewModel.getMessageObservable().getCurrentValue());
    }


}
