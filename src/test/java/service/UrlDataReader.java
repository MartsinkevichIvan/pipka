package service;

import java.util.ResourceBundle;

public interface UrlDataReader {
    String BOUNDLE_NAME = "youTubeURLs";
    String MAIN = "main";

    default String getUrl(String urlSettings) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(BOUNDLE_NAME);
        return resourceBundle.getString(urlSettings);
    }
}
