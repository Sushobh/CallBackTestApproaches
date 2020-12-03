package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class App3Test {


    private MyViewModel myViewModel;



    @Mock
    Model model;

    @BeforeEach
    void setUp() {
       MockitoAnnotations.openMocks(this);
       myViewModel = new MyViewModel(model);
    }

    @Test
    void onInit() throws Exception{
        Mockito.doAnswer(invocationOnMock -> {
            Model.ValueListener valueListener = invocationOnMock.getArgument(0);
            Assertions.assertEquals(MyViewModel.LOADING,myViewModel.getMessageObservable().getCurrentValue());
            valueListener.onFetched("asdas9dasd");
            Assertions.assertEquals(MyViewModel.FETCHED,myViewModel.getMessageObservable().getCurrentValue());
            return null;
        }).when(model).getValue(Mockito.any());
        myViewModel.onInit();
    }



}
