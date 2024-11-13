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
    public PlaylistPage deletePlaylist() {
        // Wait for and click the delete button
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();

        // Wait for the "OK" button in the confirmation dialog
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.ok"))); // Adjust the selector if needed

        // Click the "OK" button to confirm deletion
        okButton.click();

        return this;
    }

}
