import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class LoginTests extends BaseTest {

    LoginPage loginPage = null;




    @Test(description = "Check if user login with correct credentials", groups = "Smoke")
    public void loginTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("nazar@testpro.io", "Pomidor2115");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getAvatar().isDisplayed()); //true
    }

    @Test(groups = "Regression", dataProvider = "incorrectCredentials")
    public void loginWithEmptyCredentials(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.getLogo().isDisplayed());
    }
}