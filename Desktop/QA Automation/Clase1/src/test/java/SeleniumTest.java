import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utility.DriverFactory;
import utility.PropertiesFile;

public class SeleniumTest {
    private String url = PropertiesFile.getProperty("url");
    private WebDriver driver = DriverFactory.getDriver();

    @Test
    public void NavigateHomeStore() {
        driver.manage().window().maximize();
        driver.navigate().to(url);
        Assert.assertEquals("STORE", driver.getTitle());
        driver.quit();
    }
}
