import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderCredentials extends BaseTest {

    LoginPage loginPage = null;



    @Test(groups = "Regression", dataProvider = "incorrectCredentials")
    public void loginWithIncorrectCredentials(String email, String password) {
        WebElement logo = driver.findElement(By.cssSelector("[class=logo]"));
        loginPage = new LoginPage(driver);
        loginPage.login("nazar@testpro.io", "Pomidor2115");
        //empty email and password
        //empty email and empty password
        //incorrect email and correct password
        //correct email and incorrect password
        //incorrect email and incorrect password
        Assert.assertTrue(logo.isDisplayed());
    }

    @DataProvider(name = "incorrectCredentials")
    public Object [][] provideIncorrectCredentials() {
        return new Object[][] {
                {"", ""},
                {"nazar@testpro.io", ""},
                {"", "Pomidor2115"},
                {"nazar@testpro.iom", "Pomidor2115"},
                {"nazar@testpro.io", "Pomidor"},
                {"nazar@testpro.iom", "Pomidor"},

        };
    }





}
