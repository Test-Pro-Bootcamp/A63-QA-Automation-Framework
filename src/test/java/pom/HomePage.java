package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    By userAvatarIcon = By.cssSelector("img.avatar");
    By nextSongBtn = By.cssSelector("i.next.fa.fa-step-forward.control");
    By playBth = By.cssSelector("span.play");
    By songImage = By.cssSelector("#mainFooter img");
    By newPlaylistButton = By.cssSelector("#playlists .fa.fa-plus-circle.create");
    By newPlaylist = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    By namePLField = By.cssSelector(".create input[type='text']");
    By playBtn = By.cssSelector("span.album-thumb");
    By playList = By.linkText("NK_PL2");
    By deleteButton = By.cssSelector(".del.btn-delete-playlist");
    By deleteNotification = By.cssSelector(".alertify-logs.top.right");
    By albumsButton = By.xpath("//*[@id=\"sidebar\"]/section[1]/ul/li[4]/a\n");
    By albumCover = By.xpath("//*[@id=\"albumsWrapper\"]/div/article[1]");

    public void hoverOverAlbum() {actions.moveToElement(findElement(albumCover)).perform();}

    public void clickAlbumsButton() {findElement(albumsButton).click();}
    public boolean avatarIconDisplayed () {findElement(userAvatarIcon).isDisplayed();return true;}
    public void hoverOverNextSongButton() {actions.moveToElement(findElement(playBtn)).perform();}
    public void clickNextSongButton() {findElement(nextSongBtn).click();}
    public void clickPlayButton(){findElement(playBth).click();}
    public void validateSongIsPlaying(){findElement(songImage).isDisplayed();}
    public void createNewPlaylist(){findElement(newPlaylistButton).click();}
    public void clickNewPlaylist(){findElement(newPlaylist).click();}
    public void typePlaylistName(String name){
        findElement(namePLField).clear();
        findElement(namePLField).sendKeys(name);
        findElement(namePLField).sendKeys(Keys.ENTER);
    }
    public void clickOnPlaylist() {findElement(playList).click();}
    public void clickDeleteButton () {findElement(deleteButton).click();}
    public WebElement deletedPlaylistNotification() {return findElement(deleteNotification);}
    public WebElement getUserAvatar () {return findElement(userAvatarIcon);}
        }


