package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser();
    }


    // create method with name "selectMenu" it has one parameter name "menu" of type string

    public void selectMenu(String menu) {
        //   1.2 This method should click on the menu whatever name is passed as parameter.
        clickOnElement(By.linkText(menu));

    }

    @Test
    public void verifyPageNavigation() {

        //  1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
        //  select the Menu and click on it and verify the page navigation.


        clickOnElement(By.xpath("//ul[@class='top-menu notmobile'] //a[text()='Computers ']"));

        String expectedPage = "https://demo.nopcommerce.com/computers";
        String actualPage = driver.getCurrentUrl();
        Assert.assertEquals("Page not found", expectedPage, actualPage);


    }

    @After
    public void close() {
        driver.quit();
    }


}
