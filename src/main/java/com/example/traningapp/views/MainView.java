package com.example.traningapp.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route(value = "/", layout = AppView.class)
@AnonymousAllowed
public class MainView extends VerticalLayout {

    public MainView(){

        H1 title = new H1("Välkommen!");
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(title);
    }
}
