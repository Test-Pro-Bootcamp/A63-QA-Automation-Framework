package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomePage extends BasePage {

    By avatar = By.cssSelector("#userBadge img");

    By addPlaylistButton = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");

    By createPlaylist = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");

    By playlistNameInput = By.cssSelector("#playlists > form > input[type=text]");

    String playListLocator = "//section[@id='playlists']//li//a[text()='%s']";

    By editButtonLocator = By.xpath("//li[contains(@data-testid, 'playlist-context-menu-edit')]");

    By renamePlaylistInputLocator = By.cssSelector("[data-testid='inline-playlist-name-input']");

    By playLists = By.cssSelector("#playlists li");






    public HomePage(WebDriver existDriver) {
        super(existDriver);
    }


    public WebElement getAvatar() {
        return waitAndFindWebElement(avatar);
    }


    public WebElement getAddPlaylistButton() {
        return waitAndFindWebElement(addPlaylistButton);


    }


    public WebElement getCreatePlaylistButton() {
        return waitAndFindWebElement(createPlaylist);

    }


    public WebElement getPlaylistNameInput() {
        return waitAndFindWebElement(playlistNameInput);

    }

    public void createPlaylist(Actions actions, String testPlaylistName) throws InterruptedException {
        actions.moveToElement(getAddPlaylistButton()).perform();
        Thread.sleep(1000);
        getAddPlaylistButton().click();
        Thread.sleep(1000);
        getCreatePlaylistButton().click();
        getPlaylistNameInput().sendKeys(testPlaylistName);
        getPlaylistNameInput().sendKeys(Keys.ENTER);

    }

    public WebElement getPlaylistByName(String playlistName) {
        return findElement(By.xpath(String.format("//section[@id='playlists']//li//a[text()='%s']", playlistName)));


    }

    public void openPlaylist(String testPlaylistName) {
        getPlaylistByName(testPlaylistName).click();
    }


    public WebElement getPlayListByName(String PlayListName) {
        return waitAndFindWebElement(By.xpath(String.format(playListLocator, PlayListName)));

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



    public List<WebElement> getAllPlaylists() {
        return findElements(playLists);

    }



    public void createPlaylist(String playListName) throws InterruptedException {
        Thread.sleep(1000);
        getAddPlaylistButton().click();
        getCreatePlaylistButton().click();
        getPlaylistNameInput().sendKeys(playListName);
        getPlaylistNameInput().sendKeys(Keys.ENTER);
        waitUntilSuccessMessageIsDisappeared();
    }

}
