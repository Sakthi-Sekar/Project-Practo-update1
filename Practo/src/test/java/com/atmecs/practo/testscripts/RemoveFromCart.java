package com.atmecs.practo.testscripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.atmecs.practo.helpers.ValidatePracto;
import com.atmecs.practo.pages.PageActions;

public class RemoveFromCart extends AddToCart {
	ValidatePracto practo = new ValidatePracto();

	// Remove CBC Test from the cart
	@Test(priority = 3)
	public void cartAfterRemovalOfSample() throws Exception {
		Xpath = read.readPropertiesFile("loc.removecbcfromcart.xpath");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageActions.clickOnElement(driver, Xpath);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("CBC Test sample removed...");
	}

	// Validation after removing one sample test from the cart

	@Test(priority = 4)
	public void validateCartAfterRemoval() {
		practo.validateRemainingSampleNames();
		practo.validateNumberOfTestCount();
		practo.validatePriceAfterRemoval();
		practo.validatePickupChargeAfterRemoval();
		practo.validateFinalPrice();

	}
}