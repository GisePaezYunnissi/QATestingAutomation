package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreHomePage {
    @FindBy (linkText = "Laptops")
    WebElement laptopsCategory;
    WebDriver driver;

    public StoreHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Le damos acciones
    public void clickLaptopCategory() {
        laptopsCategory.click();
    }
}
