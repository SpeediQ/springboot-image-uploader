package pl.kowalczyk.springbootimageuploader.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.kowalczyk.springbootimageuploader.ImageUpader;

@Route("upload")
public class UploadGui extends VerticalLayout {
    private ImageUpader imageUpader;

    @Autowired
    public UploadGui(ImageUpader imageUpader) {
        TextField textField = new TextField();
        Button button = new Button("upload");
        button.addClickListener(buttonClickEvent -> imageUpader.uploadFile(textField.getValue()));
        add(textField);
        add(button);
    }
}
