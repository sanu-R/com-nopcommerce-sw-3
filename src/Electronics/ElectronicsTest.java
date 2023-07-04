package Electronics;

import homepage.TopMenuTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ElectronicsTest extends TopMenuTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser();

    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"), By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals("Cell phones text not found", expectedText, actualText);


    }

    @Test

    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        //2.2 Mouse Hover on “Cell phones” and click
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"), By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //2.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals("Cell phones text not found", expectedText, actualText);
        Thread.sleep(1000);
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(1000);

        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//a[contains(text()='Nokia Lumia 1020')]"));
        Thread.sleep(1000);
        //2.6 Verify the text “Nokia Lumia 1020”
        String expectedText1 = "Nokia Lumia 1020";
        String actualText1 = getTextFromElement(By.xpath("//h1[contains(text()='Nokia Lumia 1020')]"));
        Assert.assertEquals("Cell phones text not found", expectedText1, actualText1);
        Thread.sleep(1000);

        //2.7 Verify the price “$349.00”
        String expectedText2 = "$349.00";
        String actualText2 = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals("Price not found", expectedText2, actualText2);
        //2.8 Change quantity to 2
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        Thread.sleep(1000);
        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top
        String expectedText3 = "The product has been added to your shopping car";
        String actualText3 = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals("The product has been added to your shopping cart", expectedText3, actualText3);
        Thread.sleep(1000);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[@class='cart-label']"), By.xpath("//button[normalize-space()='Go to cart']"));
        //2.12 Verify the message "Shopping cart"
        String expectedText4 = "Shopping cart";
        String actualText4 = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals("Shopping cart text not found", expectedText4, actualText4);
        Thread.sleep(1000);
        //2.13 Verify the quantity is 2
        String expectedQuantity = "2";
        String actualQuantity = getTextFromElement(By.xpath("//input[@id='itemquantity11244']"));
        Assert.assertEquals("Quantity not match.", expectedQuantity, actualQuantity);
        Thread.sleep(1000);
        //2.14 Verify the Total $698.00
        String expectedPrice = "$698.00";
        String actualPrice = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text()='$698.00')]"));
        Assert.assertEquals("Price not match", expectedPrice, actualPrice);
        Thread.sleep(1000);
        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedMessage = "Welcome, Please Sign In";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Welcome text not found", expectedMessage, actualMessage);
        Thread.sleep(1000);
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.19 Verify the text “Register”
        String expectedText5 = "Register";
        String actualText5 = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Register text not found", expectedText5, actualText5);
        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Rita");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Rao");
        sendTextToElement(By.xpath("//input[@id='Email']"), "rao123@gamil.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "train123");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "train123");
        Thread.sleep(1000);
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        Thread.sleep(1000);
        //2.22 Verify the message “Your registration completed”
        String expectedMessage1 = "Your registration completed";
        String actualMessage1 = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Registration not complected", expectedMessage1, actualMessage1);
        Thread.sleep(1000);
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        // can't excess the site so couldn't finish rest of it.

    }


    @After
    public void close() {
        driver.quit();

    }
}
