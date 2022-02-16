package com.example.application.views.list;

import com.example.application.data.Services.Service;
import com.example.application.data.entity.Imatge;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class UploadStoryForm extends FormLayout {
    TextField title = new TextField("Title");
    TextField author = new TextField("Author");
    TextField theme = new TextField("Theme");
    Service service;

    Imatge imatge = new Imatge();

    Button save = new Button("Save");
    Button close = new Button("Cancel");

    public UploadStoryForm() {
        add(title, author, theme, createButtonsLayout());
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(save, close);
    }
}