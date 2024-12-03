import org.testng.Assert;
import org.testng.annotations.Test;
import PageFactory.LoginPage;
import PageFactory.HomePage;


public class HomepageTests extends BaseTest {
    @Test
    public void koelInfoPageDisplay(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("victoria.mereneanu@testpro.io")
                .providePassword("Testpro1234$")
                .clickSubmit();
        homePage.getKoelInfo();
        Assert.assertTrue(homePage.isKoelInfoDisplayed());
    }
 @Test
    public void profileLinkPageDisplay(){
     LoginPage loginPage = new LoginPage(driver);
     HomePage homePage = new HomePage(driver);

     loginPage.provideEmail("victoria.mereneanu@testpro.io")
             .providePassword("Testpro1234$")
             .clickSubmit();
     homePage.clickProfileLink();
     Assert.assertTrue(homePage.isProfileFormDisplayed());
 }
 @Test
    public void abilityToSearchTitles(){
     LoginPage loginPage = new LoginPage(driver);
     HomePage homePage = new HomePage(driver);

     loginPage.provideEmail("victoria.mereneanu@testpro.io")
             .providePassword("Testpro1234$")
             .clickSubmit();
     homePage.searchTitle("Dark days");
     Assert.
 }
}
