package com.example.application.views.list;

import com.example.application.data.Services.Service;
import com.example.application.data.entity.Imatge;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.PWA;
import com.example.application.views.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;

@PWA(name = "Flow CRM Tutorial", shortName = "Flow CRM Tutorial", enableInstallPrompt = false)
@Route(value = "", layout = MainLayout.class)
@PageTitle("Pi Story")
public class ListView extends VerticalLayout {
    @Autowired
    public ListView(Service servei) {
        setSpacing(false);

        Image img = new Image("https://i.blogs.es/949bb7/lotramazon/1366_2000.jpeg", "a");
        Imatge test = new Imatge(1,"La cosa","Yo","Terror",img);
//        servei.saveImatge(test);

        img.addClickListener(e -> {
            UI.getCurrent().navigate("image/"+test.getId());
        });

        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");

        // image carousel
        Slide s1 = new Slide(img);
        Slide s2 = new Slide(new Image("https://i.blogs.es/949bb7/lotramazon/1366_2000.jpeg", "DummyImage"));
        Slide s3 = new Slide(new Image("https://i.blogs.es/949bb7/lotramazon/1366_2000.jpeg", "DummyImage"));
        Slide s4 = new Slide(new Image("https://i.blogs.es/949bb7/lotramazon/1366_2000.jpeg", "DummyImage"));

        final Carousel cf = new Carousel(s1, s2, s3, s4).withoutNavigation();
        cf.setWidth("100%");
        cf.setMaxHeight("90%");
        Button next = new Button(new Icon(VaadinIcon.ARROW_RIGHT));
        Button prev = new Button(new Icon(VaadinIcon.ARROW_LEFT));
        next.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        prev.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        next.addClickListener(e -> cf.moveNext());
        prev.addClickListener(e -> cf.movePrev());

        cf.addChangeListener(e -> Notification.show("Slide Changed!", 1000, Notification.Position.BOTTOM_START));
        HorizontalLayout btns = new HorizontalLayout(prev, next);
        btns.setAlignItems(Alignment.CENTER);
        btns.setJustifyContentMode(JustifyContentMode.CENTER);
        btns.setWidthFull();
        add(cf, btns);

    }
}
