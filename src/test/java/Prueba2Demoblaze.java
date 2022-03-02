import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.DriverFactory;
import utility.PropertiesFile;

public class Prueba2Demoblaze {
        private String url = PropertiesFile.getProperty("url");
        private WebDriver driver = DriverFactory.getDriver();

        @Test
        public void addToCart() throws InterruptedException {
            String modelo;
            String precio;

            //Maximizo la página y navego
            driver.manage().window().maximize();
            driver.navigate().to(url);

            //Busco link a categoría laptop
            driver.findElement(By.linkText("Laptops")).click();
            Thread.sleep(2000);

            //Hacer click en el primer producto
            driver.findElement(By.cssSelector("img.card-img-top")).click();
            Thread.sleep(2000);

            //Obtengo modelo y precio del producto, imprimo por consola
            modelo = driver.findElement(By.cssSelector("h2.name")).getText();
            precio = driver.findElement(By.cssSelector("h3.price-container")).getText();
            System.out.println("Modelo:" + modelo + "Precio:" + precio);

            //Agrego al cart
            driver.findElement(By.linkText("Add to cart")).click();
            Thread.sleep(2000);
            driver.quit();
        }
}

