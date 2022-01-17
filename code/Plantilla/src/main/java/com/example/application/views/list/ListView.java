package com.example.application.views.list;

import com.example.application.data.Services.Service;
import com.example.application.data.entity.Imatge;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
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
        Button leftButton = new Button("Left", new Icon(VaadinIcon.ARROW_LEFT));
        add(leftButton);

        Button rightButton = new Button("Right",
                new Icon(VaadinIcon.ARROW_RIGHT));
                rightButton.setIconAfterText(true);
                rightButton.addClickListener(this::showButtonClickedMessage);
        add(rightButton);

//        Image img = MainLayout.eiemgis.get(contador).getSrc();
        URL imageUrl = this.getClass().getResource("/home/alumne/Imatges/Selecció_068.png");
        Image img = new Image(String.valueOf(imageUrl), "a");
        Imatge test = new Imatge("La cosa","Yo","Terror",null);
//        servei.saveImatge(test);

        img.addClickListener(e -> {
            UI.getCurrent().navigate("image/"+test.getId());
        });
        img.setWidth("75%");
        img.setHeight("75%");
        add(img);

        setSizeFull();
//        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
//        getStyle().set("text-align", "center");
    }

    private void showButtonClickedMessage(ClickEvent<Button> buttonClickEvent) {
//        img = new Image("https://i.pinimg.com/1200x/98/5d/60/985d60b311111aabe29bb6a75c6175ca.jpg", "DummyImage");
    }

}
