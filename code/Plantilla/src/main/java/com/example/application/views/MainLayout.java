package com.example.application.views;

import com.example.application.data.entity.Imatge;
import com.example.application.data.repositories.ImatgeRepository;
import com.example.application.views.list.HistoriesImatge;
import com.example.application.views.list.ListView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.theme.Theme;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Theme(themeFolder = "flowcrmtutorial")
public class MainLayout extends AppLayout {

    private Upload upload;
    private Imatge imatge;
    ImatgeRepository imatgeRepository;
    private VerticalLayout imageContainer;
    public static List<Imatge> eiemgis ;

    public MainLayout() {
        createHeader();
//        eiemgis.add(new Imatge(1, "Ring", "Manolo", "Anillos", new Image("https://i.pinimg.com/1200x/98/5d/60/985d60b311111aabe29bb6a75c6175ca.jpg", "pito")));
//        eiemgis.add(new Imatge(2, "Test", "Manolo", "Horror", new Image("https://i.blogs.es/949bb7/lotramazon/1366_2000.jpeg", "test")));

    }

    private void createHeader() {
        H1 logo = new H1("PiStory");
        logo.addClassNames("text-l", "m-m");

        HorizontalLayout header = new HorizontalLayout(logo);
        header.setWidth("80%");
        header.addClassNames("py-0", "px-m");
        addToNavbar(header);

        logo.addClickListener(e->{
            UI.getCurrent().navigate(ListView.class);
//            add(new ListView());
        });

        Button add = new Button("Add",new Icon(VaadinIcon.PLUS_CIRCLE));
        add.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        add.setWidth("10%");
        addToNavbar(add);

        add.addClickListener(e -> {
            UI.getCurrent().navigate("uploadImatge");
        });

        Button login =new Button("Login", new Icon(VaadinIcon.USER));
        login.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        login.setWidth("10%");

        login.addClickListener(e -> {
            UI.getCurrent().navigate("login");
        });

        addToNavbar(login);
    }

    public List<Imatge> getEiemgis() {
        return eiemgis;
    }

    public void setEiemgis(List<Imatge> eiemgis) {
        this.eiemgis = eiemgis;
    }


}