package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends BasePage {
    @FindBy(xpath = ("//a[@id='cartur']"))
    WebElement cart;

    public MenuPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickCart() {
        clickOnWebElement(cart);
    }
}