package com.example.traningapp.views;

import com.example.traningapp.entities.MyTraining;
import com.example.traningapp.form.MyTrainingForm;
import com.example.traningapp.service.MyTrainingService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Theme(themeClass = Lumo.class, variant = Lumo.DARK)
@Route(value = "/myTraining", layout = AppView.class)
public class MyTrainingView extends VerticalLayout implements AppShellConfigurator {

    MyTrainingService myTrainingService;
    Grid<MyTraining> grid = new Grid<>(MyTraining.class,false);
    MyTrainingForm myTrainingForm;

    public MyTrainingView(MyTrainingService myTrainingService){

        this.myTrainingService = myTrainingService;
        myTrainingForm = new MyTrainingForm(myTrainingService, this);
        setAlignItems(Alignment.BASELINE);
        grid.setItems(myTrainingService.findAll());


            grid.addColumn(MyTraining::getExercise).setHeader("Excercise").setSortable(true);
            grid.addColumn(MyTraining::getNumRep).setHeader("Reps").setSortable(true);
            grid.addColumn(MyTraining::getNumSet).setHeader("Set").setSortable(true);


        HorizontalLayout main = new HorizontalLayout(grid);
        main.setSizeFull();

        add(main);

        Button button = new Button("Add new excercise", buttonClickEvent -> {
            Dialog dialog = new Dialog();
            MyTrainingForm myTrainingForm = new MyTrainingForm(myTrainingService, this);
            myTrainingForm.setMyTraining(new MyTraining());
            dialog.add(myTrainingForm);
            dialog.open();
        });

        add(button);
    }
}
