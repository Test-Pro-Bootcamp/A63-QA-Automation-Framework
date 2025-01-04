package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    By avatar = By.cssSelector("#userBadge img");

    By newPlaylist = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");

    By simplePlaylist = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");

    By playlistName = By.cssSelector("#playlists > form > input[type=text]");



    public HomePage(WebDriver existDriver) {
        super(existDriver);
    }


    public WebElement getAvatar() {
        return findElement(avatar);
    }

    public WebElement getNewPlaylist(WebDriverWait wait) {
        return waitAndFindWebElement(wait, newPlaylist);


    }


    public WebElement getCreatePlaylistButton (WebDriverWait wait){
        return waitAndFindWebElement(wait, simplePlaylist);

    }




    public WebElement getPlaylistNameInput(WebDriverWait wait){
        return waitAndFindWebElement(wait, playlistName);

    }

    public void createPlaylist(Actions actions, WebDriverWait wait, String testPlaylistName) {
        actions.moveToElement(getNewPlaylist(wait)).perform();
        getNewPlaylist(wait).click();
        getCreatePlaylistButton(wait).click();
        getPlaylistNameInput(wait).sendKeys(testPlaylistName);
        getPlaylistNameInput(wait).sendKeys(Keys.ENTER);

    }

    public void openPlaylist(WebDriverWait wait, String testPlaylistName) {
        WebElement findPlaylist = waitAndFindWebElement(wait, By.xpath("//section[@id='playlists']//li//a[text()='Playlist 1']"));
        findPlaylist.click();
    }


}
