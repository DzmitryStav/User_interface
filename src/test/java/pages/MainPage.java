package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {

    private final ILabel label = AqualityServices.getElementFactory().getLabel(By.xpath("//pre"), "ResultFromPage");

    public MainPage() {
        super(By.xpath("//pre"), "MainPage");
    }

    public String getTextFromPage() {
        return label.getText();
    }
}
