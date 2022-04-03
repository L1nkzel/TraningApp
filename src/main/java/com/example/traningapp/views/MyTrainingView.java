package com.example.traningapp.views;

import com.example.traningapp.entities.MyTraining;
import com.example.traningapp.service.MyTrainingService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/myTraining", layout = AppView.class)
public class MyTrainingView extends VerticalLayout {

    MyTrainingService myTrainingService;
    Grid<MyTraining> grid = new Grid<>(MyTraining.class,false);

    public MyTrainingView(MyTrainingService myTrainingService){
        this.myTrainingService = myTrainingService;

//        setAlignItems(Alignment.CENTER);
        setAlignItems(Alignment.BASELINE);
        grid.setItems(myTrainingService.findAll());


        myTrainingService.findAll().forEach(myTraining -> {

            //H2 myTrainingEx = new H2(myTraining.getExercise());
//            Paragraph reps = new Paragraph(String.valueOf(myTraining.getNumRep()));
//            Paragraph set = new Paragraph(String.valueOf(myTraining.getNumSet()));

            //add(myTrainingEx,reps,set, new Hr());

            grid.addColumn(MyTraining::getExercise).setHeader("Excercise").setSortable(true);
            grid.addColumn(MyTraining::getNumRep).setHeader("Reps").setSortable(true);
            grid.addColumn(MyTraining::getNumSet).setHeader("Set").setSortable(true);


            grid.asSingleSelect();

        });
        HorizontalLayout main = new HorizontalLayout(grid);
        main.setSizeFull();


        add(main);
    }
}
