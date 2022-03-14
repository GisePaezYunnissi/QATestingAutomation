package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    @FindBy(css = "img.card-img-top")
    WebElement laptop;
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void selectProduct(int tiempo){
        WebDriverWait wait = new WebDriverWait(driver,tiempo);
        wait.until(ExpectedConditions.elementToBeClickable(laptop)).click();
    }
}
