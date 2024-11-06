package pagefactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage {
    @FindBy (css = "img.avatar" )
    WebElement avatarIcon;
    @FindBy (css = " i[data-testid=\"sidebar-create-playlist-btn\"]")
    WebElement plus;
    @FindBy (xpath ="//nav //li[@data-testid='playlist-context-menu-create-simple']")
    WebElement newPlaylist;
    @FindBy (css = "input[name='name']")
    WebElement newNameForPlaylist;
    @FindBy(css = "div.success.show")
    WebElement createdPlaylistMsg;
    @FindBy (xpath = "//section[@id = 'playlists'] //a[contains(text(), 'Playlist23')][1]")
    WebElement playlistName;
    @FindBy(css = "div.success.show")
    WebElement deleteMsg;
    @FindBy (css = "input[type='search']")
    WebElement searchField;
    @FindBy(css = "[data-testid='play-btn']")
    WebElement play;
    @FindBy(css = "i.next")
    WebElement nextSong;
    @FindBy(css = "span.play")
    WebElement playBtn;

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
        newNameForPlaylist.sendKeys(name);
        newNameForPlaylist.sendKeys(Keys.ENTER);
        return this;
    }
    public String getCreatedPlaylistMsg(){
        return createdPlaylistMsg.getText();
    }
    public HomePage findPlaylist(){
        playlistName.click();
        return this;
    }
    public String getDeletePlaylistMsg(){
        return deleteMsg.getText();
    }
    public HomePage searchSong(String songName){
        searchField.sendKeys(songName);
        return this;
    }
    public HomePage playNextSongBtn(){
        actions.moveToElement(play).perform();
        nextSong.click();
        return this;
    }
    public HomePage playButton(){
        playBtn.click();
        return this;
    }




}
