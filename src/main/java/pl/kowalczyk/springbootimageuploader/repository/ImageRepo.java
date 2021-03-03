package pl.kowalczyk.springbootimageuploader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kowalczyk.springbootimageuploader.model.ImageModel;

@Repository
public interface ImageRepo extends JpaRepository<ImageModel, Long> {

}
