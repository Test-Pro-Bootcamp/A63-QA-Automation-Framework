package PageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(css = "img[class='avatar']")
    WebElement avatarIcon;
    @FindBy(css =".playlist")
    WebElement firstPlaylist;
    @FindBy(css = "[title='Create a new playlist']")
    WebElement newPlaylistBtn;
    @FindBy(css = "li[data-testid='playlist-context-menu-create-simple']")
    WebElement simplePlaylist;
    @FindBy(css ="input[name='name']")
    WebElement playlistField;
    @FindBy(css="div[class='alertify-logs top right']")
    WebElement succesMsg;
    @FindBy(css = "input[type='search']")
    WebElement searchField;
    public HomePage(WebDriver givendriver) {super(givendriver);}
    public HomePage doubleClickPaylist() {
        doubleClick(firstPlaylist);
        return this;
    }
    public boolean isAvatarDisplayed(){
        return avatarIcon.isDisplayed();
    }
    public HomePage chooseNewPlaylist(){
        newPlaylistBtn.click();
        return this;
    }
    public HomePage choosePlaylistType(){
        simplePlaylist.click();
        return this;
    }
    public HomePage addNewName(String newName) {
        playlistField.sendKeys(newName);   // Type the name
        playlistField.sendKeys(Keys.ENTER); // Press Enter
        return this;
    }
    public boolean isPlaylistCreated(){
        return succesMsg.isDisplayed();
    }
}
