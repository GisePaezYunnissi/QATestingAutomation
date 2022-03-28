package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver driver;
    public static String driverPath = "./src/main/resources/drivers/";
    private static String browser;
    private static WebDriverWait wait;
    private static final int TIME = 10;

    public static WebDriver getDriver() {
        if(driver == null) {
            browser = PropertiesFile.getProperty("browser");
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (browser.equals("edge")) {
                System.setProperty("webdriver.edge.driver", driverPath + "msedgedriver.exe");
                driver = new EdgeDriver();
            }
        }

            //Implicit wait
            driver.manage().timeouts().implicitlyWait(TIME, TimeUnit.SECONDS);
            //Explicit wait
            wait = new WebDriverWait(driver, TIME);

            return driver;
    }

        //Retornar el wait
        public static WebDriverWait getWait(){
            return wait;
        }
}
