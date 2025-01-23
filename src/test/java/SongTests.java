import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.AllSongsPage;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import pagefactory.SearchPage;

public class SongTests extends BaseTest {
    @Test
    public  void addSongToPlaylist()  {
        String expectedSongAddedMessage = "Added 1 song into \"Playlist1.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.searchSong("Lament");
        searchPage.clickViewAllBtn().selectSong().clickAddToButton().choosePlaylist();
        Assert.assertEquals(searchPage.getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);

    }
    @Test
    public void addSongsToPlaylist(){
        String expectedAddedMsg = "Added 1 song into \"Relax mix.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.allSongsSection();
        allSongsPage.selectM33Song().selectM33Song().addSongToPlaylist();
        Assert.assertEquals(allSongsPage.getAddedMsg(), expectedAddedMsg);


    }
    @Test
    public  void playSong()  {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("bohdan.ivasiv@testpro.io").providePassword("TkSDMvReT57X$ym").submitBtn();
        homePage.playNextSongBtn().playButton();
        Assert.assertTrue(getDriver().findElement(By.cssSelector("span.pause")).isDisplayed());
    }

}
