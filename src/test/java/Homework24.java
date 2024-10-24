import POM.HomePage;
import POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework24 extends BaseTest {

    @Test
    public void renamePlaylist() throws InterruptedException{

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("dhivya.sankaran@testpro.io").providePassword("v5eUH9H2").clickLoginBtn();
        Thread.sleep(2000);
        homePage.doubleClickPlaylist();
        Thread.sleep(2000);
        homePage.renameExistingPlaylist();

        Assert.assertEquals(homePage.renamedPlaylistMsg(), "Updated playlist \"RenamedPlaylistNew.\"");
    }
}



