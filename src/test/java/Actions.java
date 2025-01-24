import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Actions extends BaseTest{

    @Test
    public void playSong() {

        navigateToPage();
        provideEmail("natalia.kalinina@testpro.io");
        providePassword("nkKoel24$");
        clickLoginButton();
        chooseAllSongsLink();
        contextClickFirstSong(); // right-click
        selectPlayOption();
        Assert.assertTrue(songIsPlaying());

    }

    @Test
    public void hoverOverPlayButton() {

        navigateToPage();
        provideEmail("natalia.kalinina@testpro.io");
        providePassword("nkKoel24$");
        clickLoginButton();
        Assert.assertTrue((hoverPlay().isDisplayed()));


    }

    public WebElement hoverPlay() {
        // .album-thumb-wrapper .play
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));


    }

    public boolean songIsPlaying(){
        WebElement soundBar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[alt='Sound bars']")));
        return soundBar.isDisplayed();
    }
    public void selectPlayOption() {
        WebElement allSongsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback")));
        allSongsLink.click();
    }

    public void contextClickFirstSong() {
        // .all-songs .items .song-item:nth-of-type(1)
        WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".all-songs .items .song-item:nth-of-type(1)")));
        actions.contextClick(firstSong);

    }

    public void chooseAllSongsLink() {
        WebElement allSongsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".songs")));
        allSongsLink.click();
    }

}
