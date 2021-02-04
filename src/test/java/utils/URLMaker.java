package utils;

import aquality.selenium.browser.AqualityServices;
import org.apache.http.client.utils.URIBuilder;

public class URLMaker {
    public static String getAuthorizationUrl(String url, String username, String password) {
        try {
            URIBuilder builder = new URIBuilder(url);
            builder.setUserInfo(username, password);

            return builder.build().toURL().toString();
        } catch (Exception e) {
            AqualityServices.getLogger().error(e.getMessage());
            return null;
        }
    }
}
