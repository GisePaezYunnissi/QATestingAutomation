const LoginPage = require('../pageobjects/login.page');
const SecurePage = require('../pageobjects/secure.page');
const StoreHomePage = require('../pageobjects/storeHomePage');
const ProductsPage = require('../pageobjects/productsPage');
const ProductsDetailPage = require('../pageobjects/productDetailPage');
const MenuPage = require('../pageobjects/menuPage');

describe('My Login application', () => {
    it('should login with valid credentials', async () => {
        await StoreHomePage.open();

        //Hago click en la categoría laptops
        await StoreHomePage.clickLaptopCategory();
        await browser.pause(2000);

        //Hacer click en el primer producto
        await ProductsPage.clickFirstLaptop();

        //Obtengo modelo y precio del producto
        const model = await ProductsDetailPage.getModel();
        const price = await ProductsDetailPage.getPrice();
        console.log("modelo: " + model);
        console.log("price: " + price);
        await browser.pause(2000);


        //Agrego al cart
        await ProductsDetailPage.clickAddToCart();

        //Hacer click en Cart
        await MenuPage.clickCart();

        //Declaro las variable
        const modelCart = cartPage.getModelCart();
        const priceCart = cartPage.getPriceCart();
        System.out.println("Modelo:" + modelCart + "Precio:" + priceCart);
        //Valido que el titulo de la columna y precio es el mismo
        Assert.assertEquals(modelo, modelCart);
        Assert.assertEquals(precio, priceCart);
        //Hacer click en el boton de ordenar
        cartPage.clickButtonPlaceOrder();


        //await LoginPage.login('tomsmith', 'SuperSecretPassword!');
        //await expect(SecurePage.flashAlert).toBeExisting();
        //await expect(SecurePage.flashAlert).toHaveTextContaining(
            //'You logged into a secure area!');
    });
});


