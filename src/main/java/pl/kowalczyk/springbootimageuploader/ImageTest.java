package pl.kowalczyk.springbootimageuploader;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ImageTest {

    private static final String cloudName = System.getenv("CLOUD_NAME");
    private static final String apiKey = System.getenv("API_KEY");
    private static final String api_secret = System.getenv("API_SECRET");

    public static void main(String[] args) throws IOException {

        photo();


    }

    private static void photo() throws IOException {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", api_secret));

        File file = new File("D:\\Zdjęcia\\Grafika & Zdjęcia\\Marcin i Kasia\\Kasia\\DSC00729.JPG");
        Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
    }
}
