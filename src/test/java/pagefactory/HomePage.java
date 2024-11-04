package pagefactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {
    @FindBy (css = "img.avatar" )
    WebElement avatarIcon;
    @FindBy (css = "i[data-testid='sidebar-create-playlist-btn']")
    WebElement plus;
    @FindBy (css = "li[data-testid='playlist-context-menu-create-simple']")
    WebElement newPlaylist;
    @FindBy (css = "input[name='name']")
    WebElement playlistName;
    @FindBy(css = "div.success.show")
    WebElement createdPlaylistMsg;
    @FindBy (xpath = "//section[@id = 'playlists'] //a[contains(text(), 'Playlist23')][1]")
    WebElement playlist;
    @FindBy(css = "div.success.show")
    WebElement deleteMsg;
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public WebElement getAvatarIcon(){
        return avatarIcon;
    }
    public HomePage plusButton(){
        plus.click();
        return this;
    }
    public HomePage newPlaylistNameBtn(){
        newPlaylist.click();
        return this;
    }
    public HomePage newPlaylistName(String name){
        playlistName.sendKeys(name);
        playlistName.sendKeys(Keys.ENTER);
        return this;
    }
    public String getCreatedPlaylistMsg(){
        return createdPlaylistMsg.getText();
    }
    public HomePage findPlaylist(){
        playlist.click();
        return this;
    }
    public String getDeletePlaylistMsg(){
        return deleteMsg.getText();
    }



}
