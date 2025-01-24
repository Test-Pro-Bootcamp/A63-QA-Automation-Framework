package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    By albumsButton = By.cssSelector("#sidebar a.albums");
    By albumCover1 = By.xpath("//*[@id=\"albumsWrapper\"]/div/article[1]");
    By albumCover2 = By.xpath("//*[@id=\"albumsWrapper\"]/div/article[2]");
    By nameOnAlbum = By.cssSelector("#albumsWrapper > div > article:nth-child(1) > footer > div > a.name");

    public void getNameOnAlbum() {
        System.out.println("The name of album is: " + findElement(nameOnAlbum).getText());
        //findElement(nameOnAlbum).getText();
    }
    public void hoverOverAlbum2() {actions.moveToElement(findElement(albumCover2));}
    public void hoverOverAlbum(){contextClick(albumCover1);}
    public void clickFirstAlbum(){findElement(albumCover2).click();}
    public void clickAlbumsButton() {findElement(albumsButton).click();}
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


