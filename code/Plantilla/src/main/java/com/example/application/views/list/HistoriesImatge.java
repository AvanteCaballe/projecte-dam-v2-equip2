package com.example.application.views.list;

import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Imatge;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import javax.persistence.Table;

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

        Imatge test = new Imatge();
        test.setTitle("Señor de los anillos");
        test.setAuthor("Tolkien");
        test.setTheme("Fantasia");

        Imatge prova = new Imatge();
        prova.setTitle("Harry Potter");
        prova.setAuthor("Marc Avante");
        prova.setTheme("Magia");

        Imatge testing = new Imatge();
        testing.setTitle("50 sombras de Gray");
        testing.setAuthor("Axel Tomàs");
        testing.setTheme("Amor");

        Imatge proving = new Imatge();
        proving.setTitle("Arcane");
        proving.setAuthor("Jhon Deiby");
        proving.setTheme("Ficció");

        grid.setItems(test, prova, testing, proving);

        grid.addClassNames("contact-grid");
        grid.setSizeFull();
        grid.setColumns("title", "author", "theme");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        add(grid);
    }

    private void showButtonClickedMessage(ClickEvent<Button> buttonClickEvent) {
//        img = new Image("https://i.pinimg.com/1200x/98/5d/60/985d60b311111aabe29bb6a75c6175ca.jpg", "DummyImage");
    }

}
