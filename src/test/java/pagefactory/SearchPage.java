package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {
    @FindBy(css = "button[data-test='view-all-songs-btn']")
    WebElement viewAllBtn;
    @FindBy (xpath = "//section[@id='songResultsWrapper'] //tr[@class='song-item'][1]")
    WebElement firstSong;
    @FindBy (css = "button.btn-add-to")
    WebElement addToButton;
    @FindBy (xpath = "//section[@id='songResultsWrapper']//li[contains(text(),'Playlist1')]")
    WebElement playlist;
    @FindBy (css = "div.success.show")
    WebElement notification;
    @FindBy(xpath = "//section[@class='songs'] //span[@class='cover']")
    WebElement song;
    @FindBy(xpath = "//section[@id='playlists'] //li[@class='playlist playlist'][1]")
    WebElement targetArea;
    public SearchPage (WebDriver givenDriver){super(givenDriver);}
    public SearchPage clickViewAllBtn(){
        wait.until(ExpectedConditions.visibilityOf(viewAllBtn)).click();
        return this;
    }
    public SearchPage selectSong(){
        wait.until(ExpectedConditions.visibilityOf(firstSong)).click();
        return this;
    }
    public SearchPage clickAddToButton(){
        wait.until(ExpectedConditions.visibilityOf(addToButton)).click();
        return this;
    }
    public SearchPage choosePlaylist(){
        playlist.click();
        return this;
    }
    public String getAddToPlaylistSuccessMsg()  {
        return wait.until(ExpectedConditions.visibilityOf(notification)).getText();
    }
    public SearchPage dragAndDropSong(){
        wait.until(ExpectedConditions.visibilityOf(song));
        wait.until(ExpectedConditions.visibilityOf(targetArea));
        actions.dragAndDrop(song, targetArea ).build().perform();
        wait.until(ExpectedConditions.visibilityOf(notification)).getText();
        return this;
    }
}
