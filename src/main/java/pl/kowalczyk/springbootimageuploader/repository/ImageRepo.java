package pl.kowalczyk.springbootimageuploader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kowalczyk.springbootimageuploader.model.AppUser;
import pl.kowalczyk.springbootimageuploader.model.Image;

public interface ImageRepo extends JpaRepository<Image, Long> {

}
