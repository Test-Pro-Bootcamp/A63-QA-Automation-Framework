package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaylistPage extends BasePage{

    By deletePlaylist = By.cssSelector("[class='del btn-delete-playlist']");


    public PlaylistPage(WebDriver existDriver) {
        super(existDriver);
    }

    public WebElement getDeletePlaylistButton(WebDriverWait wait){
        return waitAndFindWebElement(deletePlaylist);

    }


    public void deletePlaylist(WebDriverWait wait){
        getDeletePlaylistButton(wait).click();

    }

}
