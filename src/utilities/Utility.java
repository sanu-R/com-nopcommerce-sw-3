package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**1
     * This method will click on element
     */
    public void clickOnElement(By by){

        driver.findElement(by).click();
    }


    /**
     * 2
     * This method will get the text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * 3
     * This method will send  text to element.
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //********************************* Select Class Methods **************************************//

    /**
     * 4
     * 4.1This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    /**
     * 4.2This method will select the option by visible value
     */
    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
    }

    /**
     * 4.3 This method will select the option by index
     */
    public void indexSelect(By by, int indexNumber) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByIndex(indexNumber);
    }
//********************************* Alerts Class Methods **************************************//

    /**
     * 5 Alerts (5 method )
     * 5.1 Alerts method for switch to alert
     */
    public void switchTo(By by) {
        clickOnElement(by);
        driver.switchTo().alert();
    }

    /**
     * 5.2 Alerts method for accept popup
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * 5.3 Alerts method for dismiss popup
     */
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }
    /**
     * 5.4 Alerts method for Sendkey
     */
    public void sendKeyAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    /**
     * 5.5 Alerts method for gettext
     */
    public void getTextAlert() {
        driver.switchTo().alert().getText();

    }
    //********************************* mouse hover Methods **************************************//
    /**
     * 6. Action ---> mouse hover
     */
    public void mouseHover(By by, By by1)
    {
        WebElement text1 = driver.findElement(by);
        WebElement text2 = driver.findElement(by1);
        Actions actions= new Actions(driver);
        actions.moveToElement(text1).moveToElement(text2).click().build().perform();
    }













}
