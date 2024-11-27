import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() {
        login("nazar@testpro.io", "Pomidor2115");
        WebElement newPlaylist = driver.findElement(By.cssSelector("sidebar-create-playlist-btn"));
        newPlaylist.click();
        WebElement simplePlaylist = driver.findElement(By.cssSelector("playlist-context-menu-create-simple"));
        simplePlaylist.click();
        WebElement playlistName = driver.findElement(By.cssSelector("#playlists > form > input[type=text]"));
        playlistName.sendKeys("Playlist 1");
        playlistName.sendKeys(Keys.RETURN);
        WebElement createdPlaylistText = driver.findElement(By.cssSelector("[class='success show']"));
        Assert.assertTrue(createdPlaylistText.isDisplayed());
        WebElement allSongs = driver.findElement(By.cssSelector("[href='#!/songs']"));
        allSongs.click();
        WebElement testSong = driver.findElement(By.xpath("//*[@id='songsWrapper']/div/div/div[1]/table/tr[3]"));
        testSong.click();
        WebElement addTo = driver.findElement(By.cssSelector(".btn-add-to"));
        addTo.click();
        WebElement playlist1 = driver.findElement(By.cssSelector("#songsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li.playlist"));
        playlist1.click();


    }
}
