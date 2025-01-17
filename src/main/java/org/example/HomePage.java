package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    By avatar = By.cssSelector("#userBadge img");

    By newPlaylist = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");

    By simplePlaylist = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");

    By playlistNameInput = By.cssSelector("#playlists > form > input[type=text]");

    String playlistLocator = "//section[@id='playlists']//li//a[text()='%s']";

    By editButtonLocator = By.xpath("//li[contains(@data-testid, 'playlist-context-menu-edit')]");

    By renamePlaylistInputLocator = By.cssSelector("[data-testid='inline-playlist-name-input']");






    public HomePage(WebDriver existDriver) {
        super(existDriver);
    }


    public WebElement getAvatar() {
        return findElement(avatar);
    }

    public WebElement getNewPlaylist(WebDriverWait wait) {
        return waitAndFindWebElement(newPlaylist);


    }


    public WebElement getCreatePlaylistButton(WebDriverWait wait) {
        return waitAndFindWebElement(simplePlaylist);

    }


    public WebElement getPlaylistNameInput(WebDriverWait wait) {
        return waitAndFindWebElement(playlistNameInput);

    }

    public void createPlaylist(Actions actions, WebDriverWait wait, String testPlaylistName) {
        actions.moveToElement(getNewPlaylist(wait)).perform();
        getNewPlaylist(wait).click();
        getCreatePlaylistButton(wait).click();
        getPlaylistNameInput(wait).sendKeys(testPlaylistName);
        getPlaylistNameInput(wait).sendKeys(Keys.ENTER);

    }

    public WebElement getPlaylistByName(String playlistName) {
        return findElement(By.xpath(String.format("//section[@id='playlists']//li//a[text()='%s']", playlistName)));


    }

    public void openPlaylist(String testPlaylistName) {
        getPlaylistByName(testPlaylistName).click();
    }


    public WebElement getPlayListByName(String PlayListName) {
        return waitAndFindWebElement(By.xpath(String.format(playlistLocator, PlayListName)));

    }

    public void renamePlaylist(String currentPlaylistName, String newPlaylistName) throws InterruptedException {
        contextClickByElement(getPlayListByName(currentPlaylistName));
        Thread.sleep(1000);
        WebElement editButton = waitAndFindWebElement(editButtonLocator);
        editButton.click();
        WebElement renamePlaylistInput = waitAndFindWebElement(renamePlaylistInputLocator);
        for (int i = 0; i < currentPlaylistName.length(); i++) {
            renamePlaylistInput.sendKeys(Keys.BACK_SPACE);
        }
        renamePlaylistInput.sendKeys(newPlaylistName);
        renamePlaylistInput.sendKeys(Keys.ENTER);
        getSuccessMessage();
    }



}
