package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    By avatar = By.cssSelector("#userBadge img");

    By newPlaylist = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");


    public HomePage(WebDriver existDriver) {
        super(existDriver);
    }


    public WebElement getAvatar() {
        return findElement(avatar);
    }

public WebElement getNewPlaylist(WebDriverWait wait){
        return waitAndFindWebElement(wait, newPlaylist);


    }


}
