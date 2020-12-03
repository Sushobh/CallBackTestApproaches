package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class App5Test {


    private MyViewModel2 myViewModel2;

    @Mock
    Model model;


    private ValueListenerComponent valueListenerComponent = new ValueListenerComponent();


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        myViewModel2 = new MyViewModel2(model,valueListenerComponent);
    }


    @Test
    void onInit() {
        myViewModel2.onInit();
        Assertions.assertEquals(MyViewModel.LOADING,myViewModel2.getMessageObservable().getCurrentValue());
        Assertions.assertEquals(myViewModel2,valueListenerComponent.getDestination());
    }


    @Test
    void onFetchedTest() {
        myViewModel2.onFetched("adasdsad");
        Assertions.assertEquals(MyViewModel.FETCHED,myViewModel2.getMessageObservable().getCurrentValue());
    }




}