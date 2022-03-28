import Data.DataProviderDemoblaze;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.*;
import utility.PropertiesFile;

public class Demoblaze {
    private String url = PropertiesFile.getProperty("url");
    private final int TIME = 10;

    @Test(dataProvider = "toCompleteForm", dataProviderClass = DataProviderDemoblaze.class)
    public void addToCart(String name, String country, String city, String card, String month, String year) throws InterruptedException {

        //Instanciar las pages
        StoreHomePage storeHomePage = new StoreHomePage();
        ProductsPage productsPage = new ProductsPage();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        MenuPage menuPage = new MenuPage();
        CartPage cartPage = new CartPage();
        FormPage formPage = new FormPage();
        ConfirmationPage confirmationPage = new ConfirmationPage();
        WaitsPage waitsPage = new WaitsPage();

        //Navegar por la página
        storeHomePage.navigateStoreHome();

        //Busco link a categoría laptop
        storeHomePage.clickLaptopCategory();

        //Hacer click en el primer producto
        productsPage.selectProductInRange(780, 890);

        //Obtengo modelo y precio del producto, imprimo por consola
        String modelo;
        String precio;
        modelo = productDetailPage.getModel();
        precio = productDetailPage.getPrice();
        System.out.println("Modelo:" + modelo + "Precio:" + precio);

        //Agrego al cart
        productDetailPage.clickAddToCartButton();
        Assert.assertEquals(waitsPage.waitForAlert(), "Product added");

        //Hacer click en Cart
        menuPage.clickCart();

        //Declaro las variable
        String modelCart;
        String priceCart;
        modelCart = cartPage.getModelCart();
        priceCart = cartPage.getPriceCart();
        System.out.println("Modelo:" + modelCart + "Precio:" + priceCart);
        //Valido que el titulo de la columna y precio es el mismo
        Assert.assertEquals(modelo, modelCart);
        Assert.assertEquals(precio, priceCart);
        //Hacer click en el boton de ordenar
        cartPage.clickButtonPlaceOrder();

        //Completar el formulario
        formPage.formComplete(name, country, city, card, month, year);
        //Hacer click en el boton comprar
        formPage.clickButtonPurchase();

        //Mensaje de confirmación
        Assert.assertEquals(confirmationPage.getMessage(), "Thank you for your purchase!");

        //Validar price, name, card igual al modal
        Assert.assertTrue(confirmationPage.getValidate().contains(priceCart));
        Assert.assertTrue(confirmationPage.getValidate().contains(name));
        Assert.assertTrue(confirmationPage.getValidate().contains(card));

        confirmationPage.clickButtonOk();
    }

    @AfterTest

    public void AfterTest() {
        StoreHomePage storeHomePage = new StoreHomePage();
        //Cierro el navegador
        storeHomePage.quit();
    }
}

