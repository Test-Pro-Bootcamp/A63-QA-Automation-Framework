package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(css = "img[class='avatar']")
    WebElement avatarIcon;
    @FindBy(css =".playlist")
    WebElement firstPlaylist;
    @FindBy(css="li[class='playlist recently-played']")
    WebElement recentlyPlayedPlaylist;
    @FindBy(css="a[data-testid='btn-logout'] ")
    WebElement logoutBtn;
    @FindBy(css= "i[class='fa fa-info-circle']")
    WebElement infoBtn;
    @FindBy(css = "div[data-testid='about-modal']")
    WebElement aboutKoel;
    @FindBy(css ="form[data-testid='update-profile-form']")
    WebElement profileForm;
    @FindBy(css = "div[id='searchForm']")
    WebElement searchField;
    @FindBy(css = "button[data-test='view-all-songs-btn']")
    WebElement viewAllBtn;
    @FindBy(xpath = "//section[@id='songResultsWrapper'] //tr[@class='song-item'][1]")
    WebElement firstSong;
    @FindBy (css = "li[class='has-sub']")
    WebElement addToBtn;
    
    public HomePage(WebDriver givendriver) {super(givendriver);}
    public HomePage doubleClickPaylist() {
        doubleClick(firstPlaylist);
        return this;
    }
    public boolean isAvatarDisplayed(){
        return avatarIcon.isDisplayed();
    }

    public HomePage logoutUser(){
        logoutBtn.click();
        return this;
    }
    public HomePage getKoelInfo(){
        infoBtn.click();
        return this;
    }
    public boolean isKoelInfoDisplayed(){
        return aboutKoel.isDisplayed();
    }
    public HomePage clickProfileLink(){
        avatarIcon.click();
        return this;
    }
    public boolean isProfileFormDisplayed(){
        return profileForm.isDisplayed();
    }
    public HomePage searchSong(String title) {
        searchField.sendKeys(title);
        searchField.click();
        return this;
    }
    public HomePage viewAllSongs(){
        viewAllBtn.click();
        return this;
    }
    public HomePage selectFirstSong(){
        contextClick(firstSong);
        return this;
    }
    public HomePage clickAddSong(){
        addToBtn.click();
        return this;
    }
}
