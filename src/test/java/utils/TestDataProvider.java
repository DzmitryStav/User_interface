package utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestDataProvider {
    private static final ISettingsFile file = new JsonSettingsFile("testData.json");

    public static String getValue(String value) {
        return (String) file.getValue("/" + value);
    }
}
