package service;

import java.util.ResourceBundle;

public interface UrlDataReader {

    static String getUrl(String bundle, String urlSettings) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(bundle);
        return resourceBundle.getString(urlSettings);
    }
}
