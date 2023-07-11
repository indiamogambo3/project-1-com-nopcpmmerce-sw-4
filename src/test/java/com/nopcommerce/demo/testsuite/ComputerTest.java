package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComputerTest extends BaseTest {

    HomePage homePage = new HomePage();
    ComputersPage computersPage = new ComputersPage();
    DesktopPage desktopPage = new DesktopPage();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckoutPage checkoutPage = new CheckoutPage();



    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {

        homePage.selectMenu("Computers");
        computersPage.clickOnDesktop();
        desktopPage.selectDropDown("Name: Z to A");
        desktopPage.verifyProductsInDescendingOrder();
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {

        homePage.selectMenu("Computers");
        computersPage.clickOnDesktop();
        desktopPage.selectDropDown("Name: A to Z");
        desktopPage.addProductToCart();
        String expectedText = "Build your own computer";
        Assert.assertEquals(desktopPage.getErrorMessage(), expectedText, "Unable to verify text.");
        buildYourOwnComputerPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");
        buildYourOwnComputerPage.selectRam("8GB [+$60.00]");
        buildYourOwnComputerPage.selectHDDRadioButton();
        buildYourOwnComputerPage.selectOSRadioButton();
        buildYourOwnComputerPage.selectSoftware();
        Thread.sleep(2000);
        String expectedPrice = "$1,475.00";
        Assert.assertEquals(buildYourOwnComputerPage.verifyCorrectPrice(), expectedPrice, "Unable to verify price.");
        buildYourOwnComputerPage.clickOnAddToCartButton();
        String expectedMessage = "The product has been added to your shopping cart";
        Assert.assertEquals(buildYourOwnComputerPage.verifyProductHasBeenAddedText(), expectedMessage, "Unable to verify message.");
        buildYourOwnComputerPage.closeTheBar();
        buildYourOwnComputerPage.mouseHoverToShoppingCart();
        buildYourOwnComputerPage.clickOnGoToCart();
        String expectedShoppingCartMessage = "Shopping cart";
        Assert.assertEquals(shoppingCartPage.verifyTextShoppingCart(), expectedShoppingCartMessage, "Unable to verify message.");
        shoppingCartPage.clearQuantity();
        shoppingCartPage.quantityAmount("2");
        shoppingCartPage.updateShoppingCart();
        String expectedTotal = "$2,950.00";
        Assert.assertEquals(shoppingCartPage.verifyTotalAmount(), expectedTotal, "Unable to verify total.");
        shoppingCartPage.clickOnTermsOfService();
        shoppingCartPage.clickOnCheckoutButton();
        String expectedWelcomeSignInText = "Welcome, Please Sign In!";
        Assert.assertEquals(checkoutPage.verifyWelcomeSignInText(), expectedWelcomeSignInText, "Unable to verify text.");
        checkoutPage.clickOnGuestCheckout();
        checkoutPage.enterFirstName("Mukz");
        checkoutPage.enterLastName("Shah");
        checkoutPage.enterEmailId("mukz123@gmail.com");
        checkoutPage.selectCountryName("United Kingdom");
        checkoutPage.enterCityName("London");
        checkoutPage.enterAddressLine1("123 The Best Street");
        checkoutPage.enterPostalCode("LN1 1LN");
        checkoutPage.enterPhoneNumber("11223344556");
        checkoutPage.clickOnContinueButton();
        checkoutPage.clickOnNextDayAirRadioButton();
        checkoutPage.clickOnContinueLink();
        checkoutPage.selectCreditCardRadioButton();
        checkoutPage.clickOnContinue();
        checkoutPage.selectCreditCard("MasterCard");
        checkoutPage.enterCardHolderName("Mr. M. Shah");
        checkoutPage.enterCardNumber("5534 5678 1234 5678");
        checkoutPage.selectExpiryMonth("9");
        checkoutPage.selectExpiryYear("2027");
        checkoutPage.enterCardCode("587");
        checkoutPage.clickContinueButton();
        checkoutPage.verifyPaymentMethod();
        checkoutPage.verifyShippingMethod();
        checkoutPage.verifyTotalAmount();
        checkoutPage.clickOnConfirmButton();
        String expectedThankYouText = "Thank you";
        Assert.assertEquals(checkoutPage.verifyThankYouText(), expectedThankYouText, "Unable to verify message.");
        String expectedSuccessfulText = "Your order has been successfully processed!";
        Assert.assertEquals(checkoutPage.verifyOrderIsSuccessful(), expectedSuccessfulText, "Unable to verify message");
        checkoutPage.clickOnContinueButtonOnThankYouPage();
        String expectedWelcomeText = "Welcome to our store";
        Assert.assertEquals(homePage.verifyWelcomeToStoreText(), expectedWelcomeText, "Unable to verify text.");


    }


}
