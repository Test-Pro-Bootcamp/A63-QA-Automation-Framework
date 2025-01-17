import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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
        Assert.assertTrue(homePage.getPlaylistByName(newPlaylistName).isDisplayed());


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
