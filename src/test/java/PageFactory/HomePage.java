package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(css = "img[class='avatar']")
    WebElement avatarIcon;
    @FindBy(css =".playlist")
    WebElement firstPlaylist;
    @FindBy(css = "[name='name']")
    WebElement popupNotification;
    public HomePage(WebDriver givendriver) {super(givendriver);}
    public HomePage doubleClickPaylist() {
        doubleClick(firstPlaylist);
        return this;
    }
    public boolean isAvatarDisplayed(){
        return avatarIcon.isDisplayed();
    }
}