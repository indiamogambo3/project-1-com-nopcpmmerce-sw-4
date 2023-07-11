package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {





    By errorMessage = By.xpath("//div[@class = 'page-title']");
    By verifyWelcomeText = By.xpath("//h2[contains(text(),'Welcome to our store')]");
    By electronics = By.xpath("//ul[@class = 'top-menu notmobile']//a[text() = 'Electronics ']");
    By cellPhone = By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]");
    By logOut = By.xpath("//a[contains(text(),'Log out')]");


    public void selectMenu(String menu) {
        By topMenuBar = By.xpath("//ul[@class='top-menu notmobile']/li/a[text() = '" + menu + " ']");
        clickOnElement(topMenuBar);
    }

    public String getErrorMessage() {
        return getTextFromElement(errorMessage);
    }


    public String verifyWelcomeToStoreText() {
        return getTextFromElement(verifyWelcomeText);
    }

    public void mouseHoverToElectronics() {
        mouseHoverToElement(electronics);
    }

    public void mouseHoverAndClickOnCellPhones() {
        mouseHoverToElementAndClick(cellPhone);
    }

    public void clickOnLogoutLink() {
        clickOnElement(logOut);
    }


}
