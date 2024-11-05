package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinition {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("I open Login Page")
    public void openLoginPage() {
        driver.get("https://qa.koel.app/");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']"))).clear();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']"))).sendKeys(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']"))).clear();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']"))).sendKeys(password);

    }

    @And("I submit")
    public void iSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {// css = "img.avatar"
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf((WebElement) By.cssSelector("img.avatar"))).isDisplayed());

    }

    // if I want to use hooks I will use @Before and @After,
    // and change @And to @Given
/*    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }*/

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
