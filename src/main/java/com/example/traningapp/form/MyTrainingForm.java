package com.example.traningapp.form;

import com.example.traningapp.entities.MyTraining;
import com.example.traningapp.service.MyTrainingService;
import com.example.traningapp.views.MyTrainingView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;

public class MyTrainingForm extends FormLayout {

    TextField excercise = new TextField("Excercise");
    TextField reps = new TextField("Reps");
    TextField set = new TextField("Set");
    Button saveButton = new Button("Save");


    Binder<MyTraining> binder = new BeanValidationBinder<>(MyTraining.class);
    MyTrainingService myTrainingService;
    MyTrainingView myTrainingView;

    public MyTrainingForm(MyTrainingService myTrainingService, MyTrainingView myTrainingView){
        this.myTrainingService = myTrainingService;
        this.myTrainingView = myTrainingView;
        setVisible(false);
       

        saveButton.addClickListener(buttonClickEvent -> onSave());

        add(excercise,reps,set,saveButton);
    }

    private void onSave() {
        MyTraining myTraining = binder.validate().getBinder().getBean();
        if (myTraining.getId() !=0 ){
            myTrainingService.updateExerciseById(myTraining.getId(),myTraining);
        } else {
            myTrainingService.createExercise(myTraining);
        }
        setMyTraining(null);
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
