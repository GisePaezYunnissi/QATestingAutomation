package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(xpath = "//tr[@class='success']/td[2]")
    WebElement titleFirstModelAdd;
    @FindBy(xpath = "//tr[@class='success']/td[3]")
    WebElement priceFirstModelAdd;
    @FindBy(xpath = "//button[text()='Place Order']")
    WebElement buttonPlaceOrder;
    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getModelCart(){
        return titleFirstModelAdd.getText();
    }

    public String getPriceCart(){
        return priceFirstModelAdd.getText();
    }

    public void clickButtonPlaceOrder(){
        buttonPlaceOrder.click();
    }
}
