package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    public  WebDriver driver;


    public void openBrowser() {
        //launch the Chrome Browser
        driver = new ChromeDriver();

        //Open the Url into the Browser
        driver.get(baseUrl);

        //Maximise Browser
        driver.manage().window().maximize();

        //Add Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }

    public void closeBrowser() {
        driver.quit();
    }


}
