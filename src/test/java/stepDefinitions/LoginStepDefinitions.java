package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class LoginStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Given("I open Koel login page")
    public void iOpenKoelLoginPage() {
        driver.get("https://qa.koel.app/");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated (By.cssSelector("[type='email']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated (By.cssSelector("[type='password']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
    }

    @And("I submit")
    public void iSubmit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}

