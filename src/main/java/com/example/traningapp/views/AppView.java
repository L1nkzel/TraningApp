package com.example.traningapp.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;


public class AppView extends AppLayout{

    public AppView(){
        HorizontalLayout navbarLayout = new HorizontalLayout();
        H1 navbarTitle = new H1("My Training");
        Button loginButton = new Button("Login", e -> Notification.show("Coming soon..."));
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        navbarLayout.add(new DrawerToggle(),navbarTitle, loginButton);

        navbarLayout.setWidthFull();
        navbarLayout.setMargin(true);
        navbarLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        navbarLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        addToNavbar(navbarLayout);

        RouterLink myTrainingViewLink = new RouterLink("View Excercises", MyTrainingView.class);

        addToDrawer(new VerticalLayout(myTrainingViewLink));
    }
}
