import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest {

    @Test (groups = "Homework18")
    public void playSong() throws InterruptedException {
        login("nazar@testpro.io", "Pomidor2115");
        WebElement playButtonBar = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        playButtonBar.click();
        WebElement playButton = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        Thread.sleep(1000);
        playButton.click();
        WebElement pause = driver.findElement(By.cssSelector("[class='fa fa-pause']"));
        Assert.assertTrue(pause.isDisplayed());
    }


}