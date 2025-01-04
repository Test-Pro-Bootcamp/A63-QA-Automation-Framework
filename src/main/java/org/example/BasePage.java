package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    WebDriver pageDriver = null;


    public BasePage(WebDriver existDriver) {
        this.pageDriver = existDriver;
    }

    public  WebElement findElement(By locator) {
        return pageDriver.findElement(locator);

    }


    public WebElement waitAndFindWebElement(WebDriverWait wait, By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
