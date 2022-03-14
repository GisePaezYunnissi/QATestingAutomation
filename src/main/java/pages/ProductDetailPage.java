package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {
    @FindBy(css = "h2.name")
    WebElement model;
    @FindBy(css = "h3.price-container")
    WebElement price;
    @FindBy(linkText = "Add to cart")
    WebElement addToCartButton;
    WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getModel() {
        return model.getText();
    };
    public String getPrice() {
        return price.getText();
    };
    public void ClickAddToCartButton() {
        addToCartButton.click();
    };
}
