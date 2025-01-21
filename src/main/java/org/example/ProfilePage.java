package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProfilePage extends BasePage {

    By themes = By.xpath("//div[contains(@data-testid, 'theme-card')]");


    public ProfilePage(WebDriver existDriver) {
        super(existDriver);
    }

    public List<WebElement> getAllThemes() {
        return findElements(themes);

    }

    public void chooseThemesByNAME(String themeName){
        for(WebElement element : getAllThemes()){
            if (element.getText().equals(themeName)){
                element.click();

            }
        }


    }

    public boolean isThemeSelected(String themeName) {
        for (WebElement element : getAllThemes()){
            if(element.getAttribute("class").contains("selected")) {
                return true;
            }
        }
        return false;
    }

}
