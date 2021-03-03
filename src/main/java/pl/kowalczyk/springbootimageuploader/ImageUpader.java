package pl.kowalczyk.springbootimageuploader;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUpader {
   private  Cloudinary cloudinary;
    private static final String cloudName = System.getenv("CLOUD_NAME");
    private static final String apiKey = System.getenv("API_KEY");
    private static final String api_secret = System.getenv("API_SECRET");


    public ImageUpader() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", api_secret));
    }

    public String uploadFile(String path) {
        File file = new File(path);
        Map uploadResult = null;

        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        } catch (IOException e) {
            //todo
        }
        return "";

    }

}
