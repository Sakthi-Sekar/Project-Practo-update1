package com.atmecs.practo.pages;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class PageActions {
protected static WebDriver driver;

public static void selectDropdown(String xpath, String visibleText) {
WebElement element = driver.findElement(By.xpath(xpath));
Select noOfpeople = new Select(element);
noOfpeople.selectByVisibleText(visibleText);

}

public static void clickOnElement(WebDriver driver, String xpath) {
driver.findElement(By.xpath(xpath)).click();

}

public static void sendKeys(WebDriver driver, String xpath, String value) {
driver.findElement(By.xpath(xpath)).sendKeys();

}
public static void cssSendKeys(WebDriver driver, String cssSelector, String value) {
driver.findElement(By.cssSelector(cssSelector)).sendKeys(value);
try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
driver.findElement(By.cssSelector(cssSelector)).sendKeys(Keys.ENTER);


}


public static void ClickElement(WebDriver driver, final String xpath) {
FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).pollingEvery(1, TimeUnit.SECONDS)
.withTimeout(30, TimeUnit.SECONDS).ignoring(ElementNotInteractableException.class);
wait.until(new Function<WebDriver, Boolean>()
{
public Boolean apply(WebDriver driver)
{
driver.findElement(By.xpath(xpath)).click();
return true;
}
});
}
}
