import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddSongToPlaylistTest extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMsg = "Added 1 song into \"Playlist1.\"";
        provideEmail("dhivya.sankaran@testpro.io");
        providePassword("v5eUH9H2");
        clickLoginBtn();
        Thread.sleep(1000);
        searchSong("Take My Hand");
        Thread.sleep(2000);
        viewAllSongs();
        Thread.sleep(3000);
        clickFirstSong();
        clickAddTo();
        selectPlaylist();
        Thread.sleep(3000);
        Assert.assertEquals(getSuccessMsg(), expectedSongAddedMsg);

    }

    public String getSuccessMsg() {
        WebElement successMsg = driver.findElement(By.cssSelector("div.success.show"));
        return successMsg.getText();
    }

    public void selectPlaylist() {
        WebElement playlist = driver.findElement(By.cssSelector("section[id='songResultsWrapper'] li[class='favorites']"));
        playlist.click();
    }

    public void clickAddTo() {
        WebElement addTo = driver.findElement(By.xpath("//button[@title='Add selected songs to…']"));
        addTo.click();

    }

    public void clickFirstSong() {
        WebElement firstSong = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr[1]"));
        firstSong.click();
    }

    public void viewAllSongs() {
        WebElement viewAllSongs = driver.findElement(By.cssSelector("button[data-test = 'view-all-songs-btn']"));
        viewAllSongs.click();
    }

    public void searchSong(String songName) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type = 'search']"));
        searchField.clear();
        searchField.sendKeys(songName);
    }
}
