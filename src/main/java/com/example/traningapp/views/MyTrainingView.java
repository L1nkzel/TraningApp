package com.example.traningapp.views;

import com.example.traningapp.entities.MyTraining;
import com.example.traningapp.form.MyTrainingForm;
import com.example.traningapp.service.MyTrainingService;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.*;

@Theme(themeClass = Lumo.class, variant = Lumo.DARK)
@Route(value = "/myTraining", layout = AppView.class)
public class MyTrainingView extends VerticalLayout implements AppShellConfigurator {

    MyTrainingService myTrainingService;
    Grid<MyTraining> grid = new Grid<>(MyTraining.class,false);
    MyTrainingForm myTrainingForm;
    Dialog dialog = new Dialog();

    public MyTrainingView(MyTrainingService myTrainingService){

        this.myTrainingService = myTrainingService;
        myTrainingForm = new MyTrainingForm(myTrainingService, this, dialog);
        grid.setItems(myTrainingService.findAll());


        grid.addColumn(MyTraining::getExercise).setHeader("Exercise").setSortable(true);
        grid.addColumn(MyTraining::getNumRep).setHeader("Reps").setSortable(true);
        grid.addColumn(MyTraining::getNumSet).setHeader("Set").setSortable(true);
        grid.setWidth(15,Unit.REM);


        grid.addComponentColumn(myTraining -> {

            Button editButton = new Button(new Icon(VaadinIcon.EDIT), buttonClickEvent -> {
                Dialog dialog = new Dialog();
                myTrainingForm = new MyTrainingForm(myTrainingService, this,dialog);
                myTrainingService.updateExerciseById(myTraining.getId(), myTraining);
                myTrainingForm.setMyTraining(myTraining);
                dialog.add(myTrainingForm);
                dialog.setWidth(15, Unit.REM);
                dialog.open();
            });

            editButton.addThemeVariants(
                    ButtonVariant.LUMO_PRIMARY,
                    ButtonVariant.LUMO_SUCCESS,
                    ButtonVariant.LUMO_SMALL
            );

            Button deleteButton = new Button(new Icon(VaadinIcon.TRASH), buttonClickEvent -> {
                myTrainingService.deleteById(myTraining.getId());
                updateItems(); //hämtar på nytt den nya listan
            });

            deleteButton.addThemeVariants(
                    ButtonVariant.LUMO_PRIMARY,
                    ButtonVariant.LUMO_SMALL,
                    ButtonVariant.LUMO_ERROR
            );

            HorizontalLayout buttons =new HorizontalLayout(editButton,deleteButton);
            buttons.setAlignItems(Alignment.END);
            buttons.setJustifyContentMode(END);
            return buttons;

        }).setHeader("Edit & Delete").setTextAlign(ColumnTextAlign.END);


        HorizontalLayout main = new HorizontalLayout(grid, myTrainingForm);
        main.setSizeFull();

        add(main);

        Button button = new Button("Add new excercise", buttonClickEvent -> {
            Dialog dialog = new Dialog();
            MyTrainingForm myTrainingForm = new MyTrainingForm(myTrainingService, this,dialog);
            myTrainingForm.setMyTraining(new MyTraining());
            dialog.add(myTrainingForm);
            dialog.open();
            dialog.setWidth(15, Unit.REM);
            dialog.setDraggable(true);
            dialog.setCloseOnOutsideClick(true);

        });

        add(button);
    }

    public void updateItems() {
        grid.setItems(myTrainingService.findAll());
    }

}
