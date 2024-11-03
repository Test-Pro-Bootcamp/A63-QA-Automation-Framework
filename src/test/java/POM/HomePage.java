package POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    @FindBy(xpath = "//*[@id=\"playlists\"]/ul/li[3]/a")
    WebElement playlistElement;
    @FindBy(css = "[name='name']")
    WebElement playListInputField;
    @FindBy(xpath = "//div[@class=\"success show\"]")
    WebElement notification;

    public HomePage doubleClickPlaylist(){
        actions.doubleClick(playlistElement).perform();
        return this;
    }
    public void renameExistingPlaylist() throws InterruptedException{
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playListInputField.sendKeys("RenamedPlaylistNew" + Keys.ENTER);
        Thread.sleep(2000);
    }
    public String renamedPlaylistMsg(){
        return notification.getText();
    }

}
