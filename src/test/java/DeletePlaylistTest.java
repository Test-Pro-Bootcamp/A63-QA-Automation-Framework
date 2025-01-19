import org.example.HomePage;
import org.example.LoginPage;
import org.example.PlaylistPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.bouncycastle.oer.its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes.Duration;
import static org.example.WaitUtils.waitUntilVisibilityOfElementLocatedBy;

public class DeletePlaylistTest extends BaseTest {

    LoginPage loginPage = null;

    HomePage homePage = null;


    @Test
    public void deletePlaylist() {
        String PlaylistName = "PlaylistForDeleting";
        loginPage = new LoginPage(driver);
        loginPage.login("nazar@testpro.io", "Pomidor2115");
        homePage = new HomePage(driver);

        homePage.createPlaylist(actions, PlaylistName);
        homePage.openPlaylist(PlaylistName);
        PlaylistPage playlistPage = new PlaylistPage(driver);
        playlistPage.deletePlaylist(wait);
        waitUntilVisibilityOfElementLocatedBy(driver, By.xpath("//section[@id='playlists']//li//a[text()='PlaylistForDeleting']"));
        Assert.assertTrue(homePage.getPlaylistByName(PlaylistName).isDisplayed());


    }
        @Test
        public void addPlaylistTest() throws InterruptedException{
        String PlaylistName = "Playlist 1";
        loginPage = new LoginPage(driver);
        loginPage.login("nazar@testpro.io", "Pomidor2115");
        homePage = new HomePage(driver);
        int previousSize = homePage.getAllPlaylists().size();
        homePage.createPlayList(PlaylistName);
        int actualSize = homePage.getAllPlaylists().size();
        Assert.assertNotEquals(actualSize, previousSize);
    }
}
