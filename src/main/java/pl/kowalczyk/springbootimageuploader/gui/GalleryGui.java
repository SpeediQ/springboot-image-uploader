package pl.kowalczyk.springbootimageuploader.gui;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.kowalczyk.springbootimageuploader.model.ImageModel;
import pl.kowalczyk.springbootimageuploader.repository.ImageRepo;

import java.util.List;

@Route("gallery")
public class GalleryGui extends VerticalLayout {
    private ImageRepo imageRepo            ;

    @Autowired
    public GalleryGui(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;

        List<ImageModel> allPhotos = imageRepo.findAll();
        allPhotos.stream().forEach(e-> {
            Image image = new Image(e.getImageAdress(), "no image");
            add(image);
        });


    }
}
