import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    String currentPlaylistName = "Playlist 1";
    String newPlaylistName = "Playlist 2";

    @Test
    public void renamePlaylist() throws InterruptedException {

        login("nazar@testpro.io", "Pomidor2115");
//        WebElement newPlaylist = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")));
//        Thread.sleep(1000);
//        actions.moveToElement(newPlaylist).click().perform();
//        newPlaylist.click();
//        Thread.sleep(1000);
//        WebElement simplePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
//        simplePlaylist.click();
//        Thread.sleep(1000);
//        WebElement playlistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > form > input[type=text]")));
//        playlistName.sendKeys(currentPlaylistName);
//        playlistName.sendKeys(Keys.ENTER);
//        Thread.sleep(1000);
//        WebElement createdPlaylistText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='success show']")));
//        Assert.assertTrue(createdPlaylistText.isDisplayed());
//        Thread.sleep(1000);
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//section[@id='playlists']//li//a[text()='%s']", currentPlaylistName))));
        Thread.sleep(1000);
        actions.moveToElement(playlist).contextClick().perform();
        WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@data-testid, 'playlist-context-menu-edit')]")));
        actions.moveToElement(editButton).click().perform();
        WebElement inputFieldPlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='inline-playlist-name-input']")));
        for (int i = 0; i < currentPlaylistName.length(); i++) {
            inputFieldPlaylistName.sendKeys(Keys.BACK_SPACE);
        }
        inputFieldPlaylistName.sendKeys(newPlaylistName);
        inputFieldPlaylistName.sendKeys(Keys.ENTER);
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'success')]")));
        Assert.assertEquals(newPlaylistName, playlist.getText());


        playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//section[@id='playlists']//li//a[text()='%s']", newPlaylistName))));
        Thread.sleep(1000);
        actions.moveToElement(playlist).contextClick().perform();
        editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@data-testid, 'playlist-context-menu-edit')]")));
        actions.moveToElement(editButton).click().perform();
        inputFieldPlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='inline-playlist-name-input']")));
        for (int i = 0; i < newPlaylistName.length(); i++) {
            inputFieldPlaylistName.sendKeys(Keys.BACK_SPACE);
        }

        inputFieldPlaylistName.sendKeys(currentPlaylistName);
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'success')]")));
        inputFieldPlaylistName.sendKeys(Keys.ENTER);

    }


}
