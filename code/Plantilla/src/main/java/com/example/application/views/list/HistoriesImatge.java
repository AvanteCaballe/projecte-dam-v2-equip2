package com.example.application.views.list;

import com.example.application.data.entity.Imatge;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "/ola", layout = MainLayout.class)
@PageTitle("Histories")
public class HistoriesImatge extends VerticalLayout {

    Grid<Imatge> grid = new Grid<>(Imatge.class);

    public HistoriesImatge() {
        setSpacing(false);

        Image img =new Image("https://i.blogs.es/949bb7/lotramazon/1366_2000.jpeg", "DummyImage");
        img.addClickListener(e -> System.out.println("pito"));
        img.setWidth("75%");
        img.setHeight("75%");
        add(img);
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);


        grid.addClassNames("contact-grid");
        grid.setColumns("title", "author", "theme");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        add(grid);
    }


}
