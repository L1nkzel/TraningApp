package com.example.traningapp.form;

import com.example.traningapp.entities.MyTraining;
import com.example.traningapp.service.MyTrainingService;
import com.example.traningapp.views.AdminView;
import com.example.traningapp.views.MyTrainingView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;

public class MyTrainingForm extends FormLayout {

    TextField exercise = new TextField("Excercise");
    IntegerField numRep = new IntegerField("Reps");
    IntegerField numSet = new IntegerField("Set");
    Button saveButton = new Button("Save");
    Button saveButtonAdmin = new Button("Save");
    Binder<MyTraining> binder = new BeanValidationBinder<>(MyTraining.class);
    MyTrainingService myTrainingService;
    MyTrainingView myTrainingView;
    AdminView adminView;
    Dialog dialog;

    public MyTrainingForm(MyTrainingService myTrainingService, MyTrainingView myTrainingView, Dialog dialog){
        this.myTrainingService = myTrainingService;
        this.myTrainingView = myTrainingView;

        this.dialog=new Dialog();
        setVisible(false);
        binder.bindInstanceFields(this);

        saveButton.addClickListener(buttonClickEvent -> {
            onSave();
            dialog.close();
        }
        );

        add(exercise,numRep,numSet,saveButton);


    }
    public MyTrainingForm(MyTrainingService myTrainingService, AdminView adminView, Dialog dialog){
        this.myTrainingService = myTrainingService;
        this.adminView = adminView;
        this.dialog=new Dialog();
        setVisible(false);
        binder.bindInstanceFields(this);

        saveButtonAdmin.addClickListener(buttonClickEvent -> {
                    onSaveAdmin();
                    dialog.close();
                }
        );

        add(exercise,numRep,numSet,saveButtonAdmin);


    }

    private void onSave() {
        MyTraining myTraining = binder.validate().getBinder().getBean();
        if (myTraining.getId() !=0 ){
            myTrainingService.updateExerciseById(myTraining.getId(),myTraining);
        } else {
            myTrainingService.createExercise(myTraining);
        }
        setMyTraining(null);
        myTrainingView.updateItems();
        adminView.updateItems();

    }

    private void onSaveAdmin() {
        MyTraining myTraining = binder.validate().getBinder().getBean();
        if (myTraining.getId() !=0 ){
            myTrainingService.updateExerciseById(myTraining.getId(),myTraining);
        } else {
            myTrainingService.createExercise(myTraining);
        }
        setMyTraining(null);
        adminView.updateItems();

    }
    public void setMyTraining(MyTraining myTraining) {
        if (myTraining != null){
            binder.setBean(myTraining);
            setVisible(true);
        } else {
            setVisible(false);
        }

    }
}
