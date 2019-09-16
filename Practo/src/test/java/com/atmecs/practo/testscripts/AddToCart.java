package com.atmecs.practo.testscripts;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.atmecs.practo.constants.LogReports;
import com.atmecs.practo.helpers.ReadPropertiesFile;
import com.atmecs.practo.helpers.ValidatePracto;
import com.atmecs.practo.pages.PageActions;
import com.atmecs.practo.testbase.InvokeBrowser;
import com.atmecs.practo.utils.ValidateTestResult;

public class AddToCart extends InvokeBrowser {
	String Xpath;
	String cssSelector;
	ValidatePracto validata = new ValidatePracto();

// To click on diagnostics and to select city
	@Test(priority = 1)
	public void clickOnDiagnostics() throws Exception {

		ReadPropertiesFile read = new ReadPropertiesFile();

		Xpath = read.readPropertiesFile("loc.btn.diagnostics.xpath");
		PageActions.ClickElement(driver, Xpath);
		log.info("Clicked on Diagnostics...");
		Xpath = read.readPropertiesFile("loc.field.selectanycityorlocality.xpath");
		PageActions.ClickElement(driver, Xpath);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("Selected city...");
		Xpath = read.readPropertiesFile("loc.field.searchfortestsandprofiles.xpath");
		PageActions.ClickElement(driver, Xpath);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("Entered into next field to select test sample...");
//To select CBC Test
		// driver.findElement(By.cssSelector("#omniSearch")).sendKeys("CBC Test");
		cssSelector = read.readPropertiesFile("loc.field.cbctest.cssselector");
		PageActions.cssSendKeys(driver, cssSelector, "CBC Test");
		// driver.findElement(By.cssSelector("cssSelector")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("CBC Test sample selected...");
// Click on Add(CBC Test) to Cart
		Xpath = read.readPropertiesFile("loc.btn.addtocartclick.xpath");
		PageActions.clickOnElement(driver, Xpath);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("CBC Test added to cart...");

//Remove previous search(CBC Test)
		Xpath = read.readPropertiesFile("loc.select.removesymbolcbctest.xpath");
		PageActions.clickOnElement(driver, Xpath);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log.info("CBC Test search removed from the field...");
		Thread.sleep(5000);
// To select Serium Lipase 
		cssSelector = read.readPropertiesFile("loc.field.selecttestsseriumlipase.cssselector");
		Thread.sleep(5000);
		PageActions.cssSendKeys(driver, cssSelector, "Serum Lipase");
		Thread.sleep(5000);
		log.info("Serium Lipase sample selected...");

//Click on Add (serium Lipase) to Cart
		Xpath = read.readPropertiesFile("loc.addseriumlipasetocart.xpath");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageActions.clickOnElement(driver, Xpath);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("Serium Lipase added to cart...");
//To remove the last search(SeriumLipase)
		Xpath = read.readPropertiesFile("loc.select.removesymbolseriumlipase.xpath");
		PageActions.clickOnElement(driver, Xpath);
		log.info("Serium Lipase search removed from the field...");
// To select T3 T4 TSH test
		cssSelector = read.readPropertiesFile("loc.select.t3t4tsh.cssselector");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageActions.cssSendKeys(driver, cssSelector, "T3 T4 TSH");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("T3 T4 TSH sample selected...");
// Click on Add(T3 T4 TSH) to Cart
		Xpath = read.readPropertiesFile("loc.btn.addtocartt3t4tsh.xpath");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageActions.clickOnElement(driver, Xpath);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("T3 T4 TSH added to cart...");
	}
//Validation after adding test samples
	@Test(priority = 2)
	public void validateAfterAdd() throws FileNotFoundException {
		validata.namesOfSampleEqual(driver);
		validata.numberOfTestsEqual(driver);
		validata.individualSamplePriceEqual(driver);
		validata.pickUpChargeEqual(driver);
		validata.initialTotalPriceEqual(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
