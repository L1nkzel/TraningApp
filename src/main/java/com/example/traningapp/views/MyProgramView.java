package com.example.traningapp.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/", layout = AppView.class)
public class MyProgramView extends VerticalLayout {

    MyTrainingView myTrainingView;

    public MyProgramView(){

    }
}
