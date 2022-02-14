package com.example.application.views.list;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("login")
@PageTitle("Login | Vaadin CRM")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    LoginForm login = new LoginForm();
    //LoginForm.form f=login.getForm();

    Button newUser = new Button("Crea un nou usuari");

    public LoginView(){
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        login.setAction("login");

        Image img = new Image("https://i.ibb.co/52282JQ/Pi-Story-Cheek.png", "a");
        img.addClickListener(imageClickEvent -> {
            UI.getCurrent().navigate(ListView.class);
        });

        newUser.addClickListener(newUser -> {
            UI.getCurrent().navigate(RegisterView.class);
        });

        img.setHeight(112, Unit.PIXELS);
        img.setWidth(212, Unit.PIXELS);
       // login.setForgotPasswordButtonVisible("Crear usuari");

        add(img, login, newUser);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        // inform the user about an authentication error
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }
}
