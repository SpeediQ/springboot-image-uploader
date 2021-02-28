package pl.kowalczyk.springbootimageuploader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kowalczyk.springbootimageuploader.model.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    AppUser findByUsername (String username);
}
