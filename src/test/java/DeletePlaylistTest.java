import org.example.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.bouncycastle.oer.its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes.Duration;

public class DeletePlaylistTest extends BaseTest {

    LoginPage loginPage = null;


    @Test
    public void deletePlaylist() throws InterruptedException {
        String testPlaylistName = "Playlist 1";
        loginPage = new LoginPage(driver);
        loginPage.login("nazar@testpro.io", "Pomidor2115");
        Thread.sleep(1000);
        actions.moveToElement(newPlaylist).click().perform();
        newPlaylist.click();
        WebElement simplePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        simplePlaylist.click();
        WebElement playlistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > form > input[type=text]")));
        playlistName.sendKeys(testPlaylistName);
        playlistName.sendKeys(Keys.ENTER);
        WebElement createdPlaylistText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='success show']")));
        Assert.assertTrue(createdPlaylistText.isDisplayed());
        WebElement findPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li//a[text()='Playlist 1']")));
        Thread.sleep(1000);
        findPlaylist.click();
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='del btn-delete-playlist']")));
        Thread.sleep(1000);
        actions.moveToElement(deletePlaylist).click().perform();
//        WebElement deletePlaylistConfirm = driver.findElement(By.cssSelector("[button.ok]"));
//        deletePlaylistConfirm.click();
        WebElement playlistDeletedMessage = driver.findElement(By.xpath("//div[contains(@class, 'success')]"));
        Assert.assertTrue(playlistDeletedMessage.isDisplayed());


    }
        @Test
        public void addPlaylistTest() throws InterruptedException{
        String testPlaylistName = "Playlist 1";
        login("nazar@testpro.io", "Pomidor2115");
        List<WebElement> playLists = driver.findElements(By.cssSelector("#playlists li"));
        int previousSize = playLists.size();
        WebElement newPlaylist = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")));
        Thread.sleep(1000);
        actions.moveToElement(newPlaylist).click().perform();
        newPlaylist.click();
        WebElement simplePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        simplePlaylist.click();
        WebElement playlistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > form > input[type=text]")));
        playlistName.sendKeys(testPlaylistName);
        playlistName.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'success')]")));
        playLists = driver.findElements(By.cssSelector("#playlists li"));
        int actualSize = playLists.size();
        Assert.assertNotEquals(actualSize, previousSize);
    }
}
