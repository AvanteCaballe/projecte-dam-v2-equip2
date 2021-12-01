package com.example.application.views.list;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@PWA(name = "Flow CRM Tutorial", shortName = "Flow CRM Tutorial", enableInstallPrompt = false)
@Route(value = "", layout = MainLayout.class)
@PageTitle("Contacts | Vaadin CRM")
public class ListView extends VerticalLayout {

    public ListView() {
        setSpacing(false);

        Button leftButton = new Button("Left", new Icon(VaadinIcon.ARROW_LEFT));
        add(leftButton);

        Button rightButton = new Button("Right",
                new Icon(VaadinIcon.ARROW_RIGHT));
                rightButton.setIconAfterText(true);

        add(rightButton);

        Image img =new Image("https://i.pinimg.com/1200x/98/5d/60/985d60b311111aabe29bb6a75c6175ca.jpg", "DummyImage");
        add(img);

        setSizeFull();
//        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
//        getStyle().set("text-align", "center");
    }

}
