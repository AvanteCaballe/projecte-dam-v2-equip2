package com.example.application.views.list;

import com.example.application.data.Services.Service;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value = "register", layout = MainLayout.class)
@PageTitle("Register")
public class RegisterView extends VerticalLayout{
    Service service;

    H1 title = new H1("Crear usuari");

    TextField nom = new TextField("Nom");
    EmailField email = new EmailField("Email");
    PasswordField password = new PasswordField("Contrasenya");

    Button create = new Button("Crear");
    Button cancel = new Button("Cancel");

    public RegisterView(Service servei){
        this.service = servei;
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        cancel.addClickListener(listener ->{
            UI.getCurrent().navigate(ListView.class);
        });

        create.addClickListener(listener ->{
            UI.getCurrent().navigate(ListView.class);
        });

        create.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(title, nom, email, password, create, cancel);
    }
}
