package com.atmecs.konakart.utils;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

public class PageActions {
	protected static WebDriver driver;
	Actions builder = new Actions(driver);

	public static void clickOnElement(WebDriver driver, String xpath) {

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(xpath)).click();

	}

	public static void scrollDownToBottom(WebDriver driver) {

		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public static void ClickElement(WebDriver driver, final String xpath) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).pollingEvery(1, TimeUnit.SECONDS)
		.withTimeout(30, TimeUnit.SECONDS).ignoring(ElementNotInteractableException.class);
		wait.until(new Function<WebDriver, Boolean>()
		{
		public Boolean apply(WebDriver driver)
		{
		driver.findElement(By.xpath(xpath));
		return true;
		}
		});
}
}
