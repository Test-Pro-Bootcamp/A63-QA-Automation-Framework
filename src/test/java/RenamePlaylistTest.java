import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RenamePlaylistTest extends BaseTest{


    LoginPage loginPage = null;
    HomePage homePage = null;



    String currentPlaylistName = "TestPro Playlist";
    String newPlaylistName = "New Playlist";

    @Test
    public void renamePlaylist() throws InterruptedException {

        loginPage = new LoginPage(driver);
        loginPage.login("nazar@testpro.io", "Pomidor2115");
        homePage = new HomePage(driver);
        homePage.renamePlaylist(currentPlaylistName, newPlaylistName);


        Assert.assertEquals(newPlaylistName, homePage.getPlaylistByName(newPlaylistName).getText());
        //Assert.assertTrue(homePage.getPlaylistByName(newPlaylistName).isDisplayed());




    }


    @AfterMethod
    public void rollBackChanges() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.renamePlaylist(newPlaylistName, currentPlaylistName);
    }

}
