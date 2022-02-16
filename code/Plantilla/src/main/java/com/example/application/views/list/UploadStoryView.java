package com.example.application.views.list;

import com.example.application.data.Services.Service;
import com.example.application.data.entity.Historia;
import com.example.application.data.entity.Imatge;
import com.example.application.data.repositories.ImatgeRepository;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.internal.MessageDigestUtil;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;


@Route(value = "uploadStory", layout = MainLayout.class)
@PageTitle("Upload Stories")
public class UploadStoryView extends VerticalLayout {
    TextField filterText = new TextField();
    UploadStoryForm form = new UploadStoryForm();

    Imatge imatge = new Imatge();
    Historia story = new Historia();

    @Autowired
    ImatgeRepository imatgeRepository;

    @Autowired
    Service service;

    private VerticalLayout imageContainer = new VerticalLayout();

    MemoryBuffer buffer = new MemoryBuffer();
    Upload upload = new Upload(buffer);
    Div output = new Div();

    public UploadStoryView(Service service) {
        initUploaderImage();
        form.save.addClickListener(event -> {
            imatge.setAuthor(form.author.getValue());
            imatge.setTitle(form.title.getValue());
            imatge.setTheme(form.theme.getValue());
        });
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(form);
        content.setFlexGrow(1, form);
        content.addClassNames("content");
        content.setSizeFull();

        upload.addSucceededListener(event -> {
            Component component = createComponent(event.getMIMEType(),
                    event.getFileName(), buffer.getInputStream());
            output.removeAll();
            showOutput(event.getFileName(), component, output);
        });

        upload.addFileRejectedListener(event -> {
            Paragraph component = new Paragraph();
            output.removeAll();
            showOutput(event.getErrorMessage(), component, output);
        });
        upload.getElement().addEventListener("file-remove", event -> {
            output.removeAll();
            imageContainer.removeAll();
        });
        return content;
    }

    private void showImage() {
        Image image = generateImage(imatge);
        image.setHeight("100%");
        imageContainer.removeAll();
        imageContainer.add(image);
    }
    private void initUploaderImage() {
        showImage();
        add(getContent());
    }
    public Image generateImage(Imatge imatge) {
        Long id = imatge.getId();
        StreamResource sr = new StreamResource("imatge", () -> {
            Imatge attached = imatgeRepository.findWithPropertyPictureAttachedById(id);
            return new ByteArrayInputStream(attached.getSrc());
        });
        sr.setContentType("image/png");
        Image image = new Image(sr, "src");
        return image;
    }

    private Component createComponent(String mimeType, String fileName,
                                      InputStream stream) {
        if (mimeType.startsWith("text")) {
            return createTextComponent(stream);
        } else if (mimeType.startsWith("image")) {
            Image image = new Image();
            try {

                byte[] bytes = IOUtils.toByteArray(stream);
                image.getElement().setAttribute("src", new StreamResource(
                        fileName, () -> new ByteArrayInputStream(bytes)));
                try (ImageInputStream in = ImageIO.createImageInputStream(
                        new ByteArrayInputStream(bytes))) {
                    final Iterator<ImageReader> readers = ImageIO
                            .getImageReaders(in);
                    if (readers.hasNext()) {
                        ImageReader reader = readers.next();
                        try {
                            reader.setInput(in);
                            image.setWidth(reader.getWidth(0) + "px");
                            image.setHeight(reader.getHeight(0) + "px");
                        } finally {
                            reader.dispose();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            image.setSizeFull();
            return image;
        }
        Div content = new Div();
        String text = String.format("Mime type: '%s'\nSHA-256 hash: '%s'",
                mimeType, MessageDigestUtil.sha256(stream.toString()));
        content.setText(text);
        return content;

    }

    private Component createTextComponent(InputStream stream) {
        String text;
        try {
            text = IOUtils.toString(stream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            text = "exception reading stream";
        }
        return new Text(text);
    }

    private void showOutput(String text, Component content,
                            HasComponents outputContainer) {
        HtmlComponent p = new HtmlComponent(Tag.P);
        p.getElement().setText(text);
        outputContainer.add(p);
        outputContainer.add(content);
    }

}