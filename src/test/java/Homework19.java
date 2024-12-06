import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {

        login("nazar@testpro.io", "Pomidor2115");
        int width = 1920;
        int height = 1080;
        Dimension dimension = new Dimension(width, height);
        driver.manage().window().setSize(dimension);
//        WebElement newPlaylist = driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
//        newPlaylist.click();
//        Thread.sleep(1000);
//        WebElement simplePlaylist = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
//        simplePlaylist.click();
//        Thread.sleep(1000);
//        WebElement playlistName = driver.findElement(By.cssSelector("#playlists > form > input[type=text]"));
//        playlistName.sendKeys("Playlist 1");
//        Thread.sleep(1000);
//        playlistName.sendKeys(Keys.RETURN);
//        Thread.sleep(1000);
//        WebElement createdPlaylistText = driver.findElement(By.cssSelector("[class='success show']"));
//        Assert.assertTrue(createdPlaylistText.isDisplayed());
        WebElement findPlaylist = driver.findElement(By.xpath("//a[contains (text(), 'Playlist 1')]"));
        findPlaylist.click();
        WebElement deletePlaylist = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        deletePlaylist.click();
//        WebElement deletePlaylistConfirm = driver.findElement(By.cssSelector("[button.ok]"));
//        deletePlaylistConfirm.click();
        WebElement playlistDeletedMessage = driver.findElement(By.xpath("//div[contains(text(), 'Playlist 1')]"));
        Assert.assertTrue(playlistDeletedMessage.isDisplayed());


    }
}
