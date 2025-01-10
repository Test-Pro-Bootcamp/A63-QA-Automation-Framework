import org.testng.annotations.Test;

public class ProfileTest extends BaseTest{


    @Test(priority = 1)
    public void loginToKoel() {

        provideEmail("natalia.kalinina@testpro.io");
        providePassword("nkKoel24$");
        clickLoginButton();
        clickAvatarIcon();
        // providing current pswd
        provideCurrentPassword("nkKoel24$");
        // Variable for random name
        String randomName = generateRandomName();
        System.out.println("The random name is: " + randomName);
        // providing Profile (random) name
        provideProfileName(randomName);
        clickSaveButton();

//        WebElement actualProfileName = driver.findElement(By.cssSelector("#inputProfileName"));
//        Assert.assertEquals(actualProfileName.getText(), randomName);



    }


}
