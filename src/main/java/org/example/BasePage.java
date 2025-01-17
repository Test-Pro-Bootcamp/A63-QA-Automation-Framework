package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    WebDriver pageDriver = null;

    By successMessageLocator = By.xpath("//div[contains(@class,'success')]");



    public BasePage(WebDriver existDriver) {
        this.pageDriver = existDriver;
    }

    public  WebElement findElement(By locator) {
        return pageDriver.findElement(locator);

    }


    public WebElement waitAndFindWebElement(By locator) {
        WebDriverWait wait = new WebDriverWait(pageDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void contextClickByElement(WebElement element)  {
        Actions actions = new Actions(pageDriver);
        actions.contextClick(element).perform();

    }


    public WebElement getSuccessMessage() {
        return waitAndFindWebElement(successMessageLocator);

    }

}
