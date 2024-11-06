package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    public SearchPage (WebDriver givenDriver){super(givenDriver);}
    public SearchPage clickViewAllBtn(){
        viewAllBtn.click();
        return this;
    }
    public SearchPage selectSong(){
        firstSong.click();
        return this;
    }
    public SearchPage clickAddToButton(){
        addToButton.click();
        return this;
    }
    public SearchPage choosePlaylist(){
        playlist.click();
        return this;
    }
    public String getAddToPlaylistSuccessMsg(){
        return notification.getText();
    }
}
