import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test (description = "Check if user login with correct credentials", groups = "Smoke")
    public void loginWithCorrectCredentials() {
        login("nazar@testpro.io", "Pomidor2115");
        WebElement avatar = driver.findElement(By.cssSelector("#userBadge img"));
        Assert.assertTrue(avatar.isDisplayed()); //true
    }

    @Test (groups = "Regression", dataProvider = "incorrectCredentials")
    public void loginWithEmptyCredentials(String email, String password) {
        WebElement logo = driver.findElement(By.cssSelector("[class=logo]"));
        login(email, password);
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
