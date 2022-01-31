package com.example.application.views.list;

import com.example.application.data.Services.Service;
import com.example.application.data.entity.Imatge;
import com.example.application.data.repositories.ImatgeRepository;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.PWA;
import com.example.application.views.MainLayout;
import com.vaadin.flow.server.StreamResource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

@PWA(name = "Flow CRM Tutorial", shortName = "Flow CRM Tutorial", enableInstallPrompt = false)
@Route(value = "", layout = MainLayout.class)
@PageTitle("Pi Story")
public class ListView extends VerticalLayout {
    private Upload upload;
    private Imatge imatge;

    @Autowired
    ImatgeRepository imatgeRepository;

    @Autowired
    Service service;

    private VerticalLayout imageContainer = new VerticalLayout();

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
        imatge = new Imatge("La cosa","Yo","Terror");

        add(imageContainer);
        initUploaderImage();

//        Image img = MainLayout.eiemgis.get(contador).getSrc();
//        Image img = new Image("https://i.pinimg.com/1200x/98/5d/60/985d60b311111aabe29bb6a75c6175ca.jpg", "a");

//        img.addClickListener(e -> {
//            UI.getCurrent().navigate("image/"+test.getId());
//        });
//        img.setWidth("75%");
//        img.setHeight("75%");
//        add(img);

        setSizeFull();
//        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
//        getStyle().set("text-align", "center");
    }

    private void showButtonClickedMessage(ClickEvent<Button> buttonClickEvent) {
//        img = new Image("https://i.pinimg.com/1200x/98/5d/60/985d60b311111aabe29bb6a75c6175ca.jpg", "DummyImage");
    }

    private void saveProfilePicture(byte[] imageBytes) {
        imatge.setSrc(imageBytes);
        service.saveImatge(imatge);
    }

    private void showImage() {
        byte[] array = imatge.getSrc();
        Image image = generateImage(array);
        image.setHeight("100%");
        imageContainer.removeAll();
        imageContainer.add(image);
    }


    private void initUploaderImage() {
        MemoryBuffer buffer = new MemoryBuffer();
        upload = new Upload(buffer);
        upload.setAcceptedFileTypes("image/jpeg","image/jpg", "image/png", "image/gif");
        upload.addSucceededListener(event -> {
            try {
                // The image can be jpg png or gif, but we store it always as png file in this example
                BufferedImage inputImage = ImageIO.read(buffer.getInputStream());
                ByteArrayOutputStream pngContent = new ByteArrayOutputStream();
                ImageIO.write(inputImage, "png", pngContent);
                saveProfilePicture(pngContent.toByteArray());
                showImage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        add(upload);
    }

    public Image generateImage(byte[] array) {
        StreamResource sr = new StreamResource("imatge", () ->  {
            return new ByteArrayInputStream(array);
        });
        sr.setContentType("image/png");
        Image image = new Image(sr, "src");
        return image;
    }

}
