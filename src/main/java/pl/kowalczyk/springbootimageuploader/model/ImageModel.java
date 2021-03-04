package pl.kowalczyk.springbootimageuploader.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageAddress;




    public ImageModel(String imageUrl){
        this.imageAddress = imageUrl;
    }

    public ImageModel() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAdress) {
        this.imageAddress = imageAdress;
    }
}
