package com.example.application.views.list;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import com.example.application.data.entity.Imatge;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;


@Route(value = "image/:imageID", layout = MainLayout.class)
@PageTitle("Histories")
public class HistoriesImatge extends VerticalLayout implements BeforeEnterObserver {

    Grid<Imatge> grid = new Grid<>(Imatge.class);
    private Integer imageID;
    Button nou = new Button("New Story");


    public HistoriesImatge() {
        setSpacing(false);
        nou.addClickListener(e -> {
            UI.getCurrent().navigate("uploadStory");
        });

        Image img =new Image("https://i.blogs.es/949bb7/lotramazon/1366_2000.jpeg", "DummyImage");
        img.setWidth("75%");
        img.setHeight("75%");
        add(img);
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(nou);
        grid.addClassNames("contact-grid");
        grid.setColumns("title", "author", "theme");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        add(grid);
    }


    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        imageID = Integer.valueOf(event.getRouteParameters().get("imageID").get());
    }
}

