package com.example.application.views.list;

import com.example.application.data.entity.Imatge;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
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

@PWA(name = "Flow CRM Tutorial", shortName = "Flow CRM Tutorial", enableInstallPrompt = false)
@Route(value = "", layout = MainLayout.class)
@PageTitle("Pi Story")
public class ListView extends VerticalLayout {

    public ListView() {
        setSpacing(false);

        Button leftButton = new Button("Left", new Icon(VaadinIcon.ARROW_LEFT));
        add(leftButton);

        Button rightButton = new Button("Right",
                new Icon(VaadinIcon.ARROW_RIGHT));
                rightButton.setIconAfterText(true);
                rightButton.addClickListener(this::showButtonClickedMessage);
        add(rightButton);

//        Image img = MainLayout.eiemgis.get(contador).getSrc();
        Image img = new Image("https://i.pinimg.com/1200x/98/5d/60/985d60b311111aabe29bb6a75c6175ca.jpg", "pito");
        Imatge test = new Imatge(3,"La cosa","Yo","Terror",img);

        img.addClickListener(e -> {
//            UI.getCurrent().navigate("ola/" + MainLayout.eiemgis.get(contador).getIdImg());
            UI.getCurrent().navigate("image/"+test.getIdImg());
        });
        img.setWidth("75%");
        img.setHeight("75%");
        add(img);

        setSizeFull();
//        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
//        getStyle().set("text-align", "center");

        // image carousel
        Slide s1 = new Slide(createSlideContent("Slide 1", "green"));
        Slide s2 = new Slide(createSlideContent("Slide 2", "blue"));
        Slide s3 = new Slide(createSlideContent("Slide 3", "red"));
        Slide s4 = new Slide(createSlideContent("Slide 4", "yellow"));

        final Carousel cf = new Carousel(s1, s2, s3, s4).withoutNavigation();
        cf.setWidth("100%");
        cf.setHeight("180px");
        Button next = new Button(">>");
        Button prev = new Button("<<");
        Button last = new Button(">|");
        Button first = new Button("|<");
        next.addClickListener(e -> cf.moveNext());
        prev.addClickListener(e -> cf.movePrev());
        last.addClickListener(e -> cf.movePos(3));
        first.addClickListener(e -> cf.movePos(0));

        cf.addChangeListener(e -> Notification.show("Slide Changed!", 1000, Notification.Position.BOTTOM_START));
        HorizontalLayout btns = new HorizontalLayout(first, prev, next, last);
        btns.setAlignItems(Alignment.CENTER);
        btns.setJustifyContentMode(JustifyContentMode.CENTER);
        btns.setWidthFull();
        add(cf, btns);

    }

    private Component createSlideContent(String string, String color) {
        H1 label = new H1(string);
        label.getStyle().set("margin-top", "auto");
        label.getStyle().set("margin-bottom", "auto");
        VerticalLayout d = new VerticalLayout(label);
        d.setAlignItems(Alignment.CENTER);
        d.setSizeFull();
        d.getStyle().set("background-color", color);
        return d;
    }

    private void showButtonClickedMessage(ClickEvent<Button> buttonClickEvent) {
//        img = new Image("https://i.pinimg.com/1200x/98/5d/60/985d60b311111aabe29bb6a75c6175ca.jpg", "DummyImage");
    }

}
