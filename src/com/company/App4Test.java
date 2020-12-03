package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class App4Test {

    private MyViewModel myViewModel;



    @Mock
    Model model;

    @Captor
    private ArgumentCaptor<Model.ValueListener> dummyCaptor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        myViewModel = new MyViewModel(model);
    }

    @Test
    void onInit() throws Exception{
        myViewModel.onInit();
        Mockito.verify(model).getValue(dummyCaptor.capture());
        Assertions.assertEquals(MyViewModel.LOADING,myViewModel.getMessageObservable().getCurrentValue());
        dummyCaptor.getValue().onFetched("asd334");
        Assertions.assertEquals(MyViewModel.FETCHED,myViewModel.getMessageObservable().getCurrentValue());
        dummyCaptor.capture();
    }



}
