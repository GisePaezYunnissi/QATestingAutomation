package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    @FindBy(xpath = "//tr[@class='success']/td[2]")
    WebElement titleFirstModelAdd;
    @FindBy(xpath = "//tr[@class='success']/td[3]")
    WebElement priceFirstModelAdd;
    @FindBy(xpath = "//button[text()='Place Order']")
    WebElement buttonPlaceOrder;

    public CartPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getModelCart() {
        return getTextFromWebElement(titleFirstModelAdd);
    }

    public String getPriceCart() {
        return getTextFromWebElement(priceFirstModelAdd);
    }

    public void clickButtonPlaceOrder() {
        clickOnWebElement(buttonPlaceOrder);
    }
}
