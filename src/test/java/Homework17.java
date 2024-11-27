import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        login("nazar@testpro.io", "Pomidor2115");
//        WebElement newPlaylist = driver.findElement(By.cssSelector("sidebar-create-playlist-btn"));
//        newPlaylist.click();
//        WebElement simplePlaylist = driver.findElement(By.cssSelector("playlist-context-menu-create-simple"));
//        simplePlaylist.click();
//        WebElement playlistName = driver.findElement(By.cssSelector("#playlists > form > input[type=text]"));
//        playlistName.sendKeys("Playlist 1");
//        playlistName.sendKeys(Keys.RETURN);
//        WebElement createdPlaylistText = driver.findElement(By.cssSelector("[class='success show']"));
//        Assert.assertTrue(createdPlaylistText.isDisplayed());
        int width = 1920;
        int height = 1080;
        Dimension dimension = new Dimension(width, height);
        driver.manage().window().setSize(dimension);
        WebElement allSongs = driver.findElement(By.cssSelector("[href='#!/songs']"));
        allSongs.click();
        Thread.sleep(500);
        WebElement testSong = driver.findElement(By.xpath("//*[@id='songsWrapper']/div/div/div[1]/table/tr[3]"));
        testSong.click();
        Thread.sleep(500);
        WebElement addTo = driver.findElement(By.cssSelector("#songsWrapper > header > div.song-list-controls > span > button.btn-add-to"));
        addTo.click();
        Thread.sleep(500);
        WebElement playlist1 = driver.findElement(By.xpath("//*[@id='songsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        playlist1.click();
        Thread.sleep(500);
        //WebElement songAdded = driver.findElement(By.cssSelector("[class=success show]"));

    }
}
