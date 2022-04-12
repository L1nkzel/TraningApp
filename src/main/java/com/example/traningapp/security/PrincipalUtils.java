package com.example.traningapp.security;

import com.example.traningapp.entities.Users;
import com.example.traningapp.repo.UsersRepo;
import com.example.traningapp.views.MyTrainingView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PrincipalUtils {

    @Autowired
    UsersRepo usersRepo;

    public Users getUserFromPrincipal(){
        return usersRepo.findUsersByUserName(getName()).orElseThrow();
    }

    public static String getName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public static boolean isAuthenticated(){
        return !SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName()
                .equalsIgnoreCase("anonymousUser");
    }

    public static Collection<? extends GrantedAuthority> getRoles(){
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }

    public static void logout(){
        UI.getCurrent().navigate(MyTrainingView.class);
        new SecurityContextLogoutHandler().logout(VaadinServletRequest.getCurrent().getHttpServletRequest(),null,null);
    }

}
