package pl.kowalczyk.springbootimageuploader;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kowalczyk.springbootimageuploader.model.ImageModel;
import pl.kowalczyk.springbootimageuploader.repository.ImageRepo;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUpader {
    private Cloudinary cloudinary;
    private ImageRepo imageRepo;
    Map uploadResult;

    private static final String cloudName = System.getenv("CLOUD_NAME");
    private static final String apiKey = System.getenv("API_KEY");
    private static final String api_secret = System.getenv("API_SECRET");

    @Autowired
    public ImageUpader(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", api_secret));
    }

    public String uploadFile(String path) {
        File file = new File(path);
        uploadResult = null;

        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            imageRepo.save(new ImageModel(uploadResult.get("url").toString()));
        } catch (IOException e) {
            //todo
        }
        return uploadResult.get("url").toString();

    }

    public void saveToDb(){
        imageRepo.save(new ImageModel(uploadResult.get("url").toString()));
    }

}
