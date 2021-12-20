package com.example.application.views;

import com.example.application.data.entity.Imatge;
import com.example.application.views.list.HistoriesImatge;
import com.example.application.views.list.ListView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.theme.Theme;

import java.util.List;

@Theme(themeFolder = "flowcrmtutorial")
public class MainLayout extends AppLayout {

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
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");
        addToNavbar(header);

        logo.addClickListener(e->{
            UI.getCurrent().navigate(ListView.class);
//            add(new ListView());
        });
    }

    public List<Imatge> getEiemgis() {
        return eiemgis;
    }

    public void setEiemgis(List<Imatge> eiemgis) {
        this.eiemgis = eiemgis;
    }
}