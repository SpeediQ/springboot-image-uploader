package pl.kowalczyk.springbootimageuploader.gui;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
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


        if (imageRepo.count()>0){
            List<ImageModel> allPhotos = imageRepo.findAll();
            allPhotos.stream().forEach(e-> {
                Image image = new Image(e.getImageAddress(), "no image");

                image.setWidth("60%");
                add(image);
            });
        }else{
            Label label = new Label("Gallery is empty");
            add(label);

        }



    }
}
