package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser();

    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        //1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
        Thread.sleep(1000);
        //1.2 Click on Desktop
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"), By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        Thread.sleep(1000);
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        Thread.sleep(1000);

        //1.4 Verify the Product will arrange in Descending order.
        String expectedText = "Name: Z to A";
        String actualTextElement = getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        Assert.assertEquals("message not displayed", expectedText, actualTextElement);
        Thread.sleep(1000);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
        Thread.sleep(1000);
        //2.2 Click on Desktop
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"), By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        Thread.sleep(1000);
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");

        Thread.sleep(1000);
        //2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("//div[@class='buttons']//button[text()='Add to cart']"));
        Thread.sleep(1000);
        //2.5 Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("Build your computer text not found", expectedText, actualText);
        Thread.sleep(1000);
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        Thread.sleep(100);

        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        Thread.sleep(1000);
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        Thread.sleep(1000);
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//label[text()='Vista Premium [+$60.00]']"));
        Thread.sleep(1000);
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        //   clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        Thread.sleep(1000);

        //2.11 Verify the price "$1,475.00"
        String expectedPrice = "$1,475.00";
        String actualPrice = getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        Assert.assertEquals("Price not match", expectedPrice, actualPrice);
        Thread.sleep(1000);
        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        Thread.sleep(1000);
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals("Product not been added to cart", expectedMessage, actualMessage);
        Thread.sleep(1000);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        Thread.sleep(1000);
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"), By.xpath("//button[contains(text(),'Go to cart')]"));
        Thread.sleep(1000);
        //2.15 Verify the message "Shopping cart"
        String expectedMessage1 = "Shopping cart";
        String actualMessage1 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Shoppping cart text not found", expectedMessage1, actualMessage1);
        Thread.sleep(1000);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();

        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.xpath("//button[@class='button-2 update-cart-button']"));
        Thread.sleep(1000);
        //2.17 Verify the Total"$2,950.00"
        String expectedTotal = "$2,950.00";
        String actualTotal = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals("Price not match", expectedTotal, actualTotal);
        Thread.sleep(1000);
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(1000);
        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedText1 = "Welcome, Please Sign In!";
        String actualText1 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Welcome text not found", expectedText1, actualText1);
        Thread.sleep(1000);
        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Rita");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Rao");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "realle123@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "3,Downing Street");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "SW1A 2AA");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07622222222");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']//button[text()='Continue']"));
        Thread.sleep(1000);
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@value='Next Day Air___Shipping.FixedByWeightByTotal']"));
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        Thread.sleep(1000);
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        Thread.sleep(1000);


        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Rita Smith");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5425233430109903");
        sendTextToElement(By.xpath("//select[@id='ExpireMonth']"), "12");
        sendTextToElement(By.xpath("//select[@id='ExpireYear']"), "2026");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "0136");
        Thread.sleep(1000);
        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.30 Verify “Payment Method” is “Credit Card”
        String expectedText2 = "Credit Card";
        String actualText2 = getTextFromElement(By.xpath("//span[contains(text()='Credit Card']"));
        Assert.assertEquals("Credit card text not found", expectedText2, actualText2);
        Thread.sleep(1000);
        //2.32 Verify “Shipping Method” is “Next Day Air”
        String expectedText3 = "Next Day Air";
        String actualText3 = getTextFromElement(By.xpath("//li[@class='shipping-method']/span[@class='value']"));
        Assert.assertEquals("Text not found", expectedText3, actualText3);
        //2.33 Verify Total is “$2,950.00”
        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        Thread.sleep(1000);
        //2.35 Verify the Text “Thank You”
        String expectedText4 = "Thank You";
        String actualText4 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Credit card text not found", expectedText4, actualText4);
        Thread.sleep(1000);

        //2.36 Verify the message “Your order has been successfully processed!”
        String expectedText5 = "Your order has been successfully processed!";
        String actualText5 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Oder not processed", expectedText5, actualText5);
        Thread.sleep(1000);
        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        Thread.sleep(1000);

        //2.37 Verify the text “Welcome to our store”
        String expectedText6 = "Welcome to our store";
        String actualText6 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Welcome message not found", expectedText6, actualText6);
        Thread.sleep(1000);


    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
