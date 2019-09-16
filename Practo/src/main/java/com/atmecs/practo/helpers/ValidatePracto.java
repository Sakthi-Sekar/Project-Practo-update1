package com.atmecs.practo.helpers;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.atmecs.practo.helpers.ReadPropertiesFile;
import com.atmecs.practo.testbase.InvokeBrowser;
import com.atmecs.practo.utils.ValidateTestResult;

public class ValidatePracto extends InvokeBrowser {
	String Xpath;
	
	ReadPropertiesFile read = new ReadPropertiesFile();

	public void namesOfSampleEqual(WebDriver driver) throws FileNotFoundException {
// first sample name
		Xpath = read.readPropertiesFile("loc.validate.firstsamplename.xpath");
		String firstsample = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(firstsample, "Complete Blood Count Automated Blood",
				"Names are equals and test passed");
// second sample name
		Xpath = read.readPropertiesFile("loc.validate.secondsamplename.xpath");
		String secondsample = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(secondsample, "Lipase Blood", "Names are equals and test passed");
// third sample name
		Xpath = read.readPropertiesFile("loc.validate.thirdsamplename.xpath");
		String thirdsample = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(thirdsample, "Thyroid Profile Total Blood", "Names are equals and test passed");
	}

// Validatation of no. of items added to the cart
	public void numberOfTestsEqual(WebDriver driver) throws FileNotFoundException {
		Xpath = read.readPropertiesFile("loc.validate.nooftestsincart.xpath");
		String tests = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(tests, "3 Tests", "Tests are equals and test passed");
	}

// Validatation of individual price after adding test samples
	public void individualSamplePriceEqual(WebDriver driver) throws FileNotFoundException {

		// first sample price
		Xpath = read.readPropertiesFile("loc.validate.firstsampleprice.xpath");
		String firstsampleprice = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(firstsampleprice, "300", "Price is equal and test passed");
//second sample price
		Xpath = read.readPropertiesFile("loc.validate.secondsampleprice.xpath");
		String secondsampleprice = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(secondsampleprice, "340", "Price is equal and test passed");
//third sample price
		Xpath = read.readPropertiesFile("loc.validate.thirdsampleprice.xpath");
		String thirddsampleprice = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(thirddsampleprice, "400", "Price is equal and test passed");

	}

//Validation of pickup charge after adding samples
	public void pickUpChargeEqual(WebDriver driver) throws FileNotFoundException {
		Xpath = read.readPropertiesFile("loc.validate.pickupcharge.xpath");
		String pickupcharge = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(pickupcharge, "₹ 0", "Price equals and test passed");
	}

// Validation of initial total price after adding samples
	public void initialTotalPriceEqual(WebDriver driver) throws FileNotFoundException {
		Xpath = read.readPropertiesFile("loc.validate.inittotalprice.xpath");
		String price = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(price, "₹ 1040", "Price equals and test passed");
		// Validation of total price after removing one sample test

	}
	public void validateRemainingSampleNames() {
		
		// Validation for names of remaining samples in cart after removal
		Xpath = read.readPropertiesFile("loc.validate.sample1nameafterremove.xpath");
		String sample1 = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(sample1, "Lipase Blood", "Names are equals and test passed");

		Xpath = read.readPropertiesFile("loc.validate.sample2nameafterremove.xpath");
		String sample2 = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(sample2, "Thyroid Profile Total Blood", "Names are equals and test passed");
	}
	public void validateNumberOfTestCount() {
		// Validation for no.of tests in cart
		Xpath = read.readPropertiesFile("loc.validate.testcountsafterremove.xpath");
		String testcounts = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(testcounts, "2 Tests", "Tests are equals and test passed");

	}
	public void validatePriceAfterRemoval() {
		// Validation of remaining samples individual prices
		Xpath = read.readPropertiesFile("loc.validate.remainingprice.firsttest.xpath");
		String firsttestprice = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(firsttestprice, "340", "Price is equal and test passed");

		Xpath = read.readPropertiesFile("loc.validate.remainingprice.secondtest.xpath");
		String secondtestprice = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(secondtestprice, "400", "Price is equal and test passed");

		
		
	}
	public void validatePickupChargeAfterRemoval() {
		
		// Validation of pickup charge after removal of one sample from cart

		Xpath = read.readPropertiesFile("loc.validate.afterremove.pickupcharge.xpath");
		String pickupcharge = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(pickupcharge, "₹ 0", "Price equals and test passed");
	}
	public void validateFinalPrice() {
		
		// Validation of final total price after removal of one sample
		Xpath = read.readPropertiesFile("loc.validate.afterremoval.finalprice.xpath");
		String finalprice = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(finalprice, "₹ 740", "Price equals and test passed");
	}


	
}