package pl.kowalczyk.springbootimageuploader.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
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
        this.imageUpader = imageUpader;
        Label label = new Label();



        TextField textField = new TextField();
        Button btnUpload = new Button("upload");
        btnUpload.addClickListener(buttonClickEvent -> {
            String imageUrl = imageUpader.uploadFile(textField.getValue());
            imageUpader.saveToDb();
            Image image = new Image(imageUrl, "no picture");
            label.setText("Success. URL to photo"+imageUrl);
            add(label);
            add(image);
        });


        add(textField);
        add(btnUpload);
    }


}
