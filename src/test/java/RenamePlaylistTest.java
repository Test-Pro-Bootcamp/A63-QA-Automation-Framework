import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RenamePlaylistTest extends BaseTest{

    String currentPlaylistName = "Playlist 1";
    String newPlaylistName = "Playlist 2";

    @Test
    public void renamePlaylist() throws InterruptedException {

        login("nazar@testpro.io", "Pomidor2115");

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
