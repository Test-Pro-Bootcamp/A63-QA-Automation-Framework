import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PlaySongByActionClickTest extends BaseTest {

    @Test
    public void playSongByContextClick() {
        String songLocator = "//article[@data-test='song-card']//span[contains(text(), '%s')]";
        String songName = "Way Of The Samurai";
        login("nazar@testpro.io", "Pomidor2115");
        int width = 1920;
        int height = 1080;
        Dimension dimension = new Dimension(width, height);
        driver.manage().window().setSize(dimension);
        WebElement allSongsMenuItem = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='sidebar'] .songs")));
        actions.click(allSongsMenuItem).perform();
        WebElement song = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(songLocator, songName))));
        actions.contextClick(song).perform();
        WebElement playFromContextMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='song-context-menu'] .playback")));
        actions.click(playFromContextMenu).perform();
        WebElement pause = driver.findElement(By.cssSelector("[class='fa fa-pause']"));
        Assert.assertTrue(pause.isDisplayed());

    }
}
