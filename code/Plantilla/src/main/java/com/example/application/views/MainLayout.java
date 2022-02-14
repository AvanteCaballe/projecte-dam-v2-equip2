package com.example.application.views;

import com.example.application.data.entity.Imatge;
import com.example.application.data.repositories.ImatgeRepository;
import com.example.application.views.list.ListView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.theme.Theme;

import java.util.List;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

@Theme(themeFolder = "flowcrmtutorial")
public class MainLayout extends AppLayout {

    private Upload upload;
    private Imatge imatge;
    ImatgeRepository imatgeRepository;
    private VerticalLayout imageContainer;
    public static List<Imatge> eiemgis ;

    public MainLayout() {
        createHeader();
        //createDrawer();
//        eiemgis.add(new Imatge(1, "Ring", "Manolo", "Anillos", new Image("https://i.pinimg.com/1200x/98/5d/60/985d60b311111aabe29bb6a75c6175ca.jpg", "pito")));
//        eiemgis.add(new Imatge(2, "Test", "Manolo", "Horror", new Image("https://i.blogs.es/949bb7/lotramazon/1366_2000.jpeg", "test")));

    }

    private void createHeader() {
        H1 logo = new H1("");
        logo.addClassNames("text-l", "m-m");

        Image logo1 = new Image("https://i.ibb.co/52282JQ/Pi-Story-Cheek.png", "a");
        logo1.setHeight(56, Unit.PIXELS);
        logo1.setWidth(106, Unit.PIXELS);
        logo1.addClickListener(e->{
            UI.getCurrent().navigate(ListView.class);
        });
        addToNavbar(logo1);

        HorizontalLayout header = new HorizontalLayout(logo);
        header.setWidth("70%");
        header.addClassNames("py-0", "px-m");
        addToNavbar(header);

        logo.addClickListener(e->{
            UI.getCurrent().navigate(ListView.class);
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
        addToNavbar(login);

        login.addClickListener(e -> {
            UI.getCurrent().navigate("login");
        });

        Button logout= new Button("Logout", new Icon(VaadinIcon.OUT));
        logout.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        logout.setWidth("10%");
        addToNavbar(logout);
    }

    private void createDrawer() {
        RouterLink listLink = new RouterLink("List", ListView.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(
            listLink
            //new RouterLink("List", ListView.class)
        ));
    }

    public List<Imatge> getEiemgis() {
        return eiemgis;
    }

    public void setEiemgis(List<Imatge> eiemgis) {
        this.eiemgis = eiemgis;
    }


}