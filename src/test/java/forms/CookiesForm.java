package forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CookiesForm extends Form {
    private final String ACCEPT_BUTTON_XPATH = "//button[contains(@class,'button button--solid button--transparent')]";

    private final IElementFactory elementFactory = AqualityServices.getElementFactory();
    private final IButton btnAccept = elementFactory.getButton(By.xpath(ACCEPT_BUTTON_XPATH), "Accept cookie using button");

    protected CookiesForm() {
        super(By.className("cookies"), "Cookies");
    }

    public void acceptCookies() {
        btnAccept.click();
    }
}
