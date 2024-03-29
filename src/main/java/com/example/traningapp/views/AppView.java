package com.example.traningapp.views;

import com.example.traningapp.security.PrincipalUtils;
import com.vaadin.flow.component.UI;
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
import org.springframework.security.core.authority.SimpleGrantedAuthority;


public class AppView extends AppLayout{

    public AppView(){
        HorizontalLayout navbarLayout = new HorizontalLayout();
        H1 navbarTitle = new H1("My Training");
        navbarLayout.add(new DrawerToggle(),navbarTitle);


        Button loginButton = new Button("Login", e -> UI.getCurrent().navigate(LoginView.class));
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Button logoutButton = new Button("Logout", evt -> PrincipalUtils.logout());
        logoutButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        navbarLayout.add(PrincipalUtils.isAuthenticated() ? logoutButton : loginButton);

        if(PrincipalUtils.isAuthenticated())
            Notification.show(PrincipalUtils.getName());

        navbarLayout.setWidthFull();
        navbarLayout.setMargin(true);
        navbarLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        navbarLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        addToNavbar(navbarLayout);
        VerticalLayout drawerLayout = new VerticalLayout();
        RouterLink mainViewLink = new RouterLink("Home", MainView.class);
        RouterLink myTrainingViewLink = new RouterLink("Exercises", MyTrainingView.class);
        RouterLink adminViewLink = new RouterLink("Admin", AdminView.class);


        if (PrincipalUtils.getRoles().stream().anyMatch(grantedAuthority -> grantedAuthority.equals(new SimpleGrantedAuthority("ROLE_ADMIN")))){
            drawerLayout.add(mainViewLink, adminViewLink);
        } else {
            drawerLayout.add(mainViewLink, myTrainingViewLink);
        }

        addToDrawer(drawerLayout);
    }
}
