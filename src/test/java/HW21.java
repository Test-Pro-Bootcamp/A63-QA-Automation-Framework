import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class HW21 extends BaseTest{

    @Test
    public void renamePlaylist() throws InterruptedException {
        String testPlaylistName = "Playlist 1";
        String testPlaylistChangedName = UUID.randomUUID().toString();
        login("nazar@testpro.io", "Pomidor2115");
        WebElement newPlaylist = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")));
        Thread.sleep(1000);
        actions.moveToElement(newPlaylist).click().perform();
        newPlaylist.click();
        Thread.sleep(1000);
        WebElement simplePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        simplePlaylist.click();
        Thread.sleep(1000);
        WebElement playlistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > form > input[type=text]")));
        playlistName.sendKeys(testPlaylistName);
        playlistName.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        WebElement createdPlaylistText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='success show']")));
        Assert.assertTrue(createdPlaylistText.isDisplayed());
        Thread.sleep(1000);
        WebElement playlist1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li [@class='playlist playlist']")));
        actions.moveToElement(playlist1).doubleClick().perform();
        //actions.moveToElement(playlist1).contextClick().perform();
        Thread.sleep(1000);
//        WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-edit-101419']")));
//        actions.moveToElement(editButton).click().perform();
        WebElement inputFieldPlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='inline-playlist-name-input']")));
        actions.doubleClick(inputFieldPlaylistName).perform();
        inputFieldPlaylistName.clear();
        Thread.sleep(1000);
        inputFieldPlaylistName.sendKeys(testPlaylistChangedName); //does not work, needs to be reviewed
        Thread.sleep(1000);
        inputFieldPlaylistName.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        WebElement playlistNameLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playlist")));
        Assert.assertEquals(testPlaylistChangedName, playlistNameLabel.getText());
    }


}
