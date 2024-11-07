package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistPage extends BasePage {
    @FindBy(css = "button.del")
    WebElement deleteBtn;

    public PlaylistPage (WebDriver givenDriver){super(givenDriver);}
    public PlaylistPage deletePlaylist(){
        deleteBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ok"))).sendKeys(Keys.ENTER);
        return this;
    }
}
