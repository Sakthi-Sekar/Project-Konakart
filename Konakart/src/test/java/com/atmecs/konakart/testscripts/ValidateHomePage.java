package com.atmecs.konakart.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.atmecs.konakart.testbase.InvokeBrowser;
import com.atmecs.konakart.utils.PageActions;
import com.atmecs.konakart.utils.ValidateTestResult;

public class ValidateHomePage extends InvokeBrowser {
	// validation of tabs in homepage using breadcrumbs(dynamic xpath is used)
	@Test(priority = 2)
	public void validateTabsHomePage() {
		Xpath = read.readPropertiesFile("loc.click.tab.computer.xpath");
		PageActions.clickOnElement(driver, Xpath);

		Xpath = read.readPropertiesFile("loc.validate.computer.breadcrumb.xpath");
		String computerbreadcrumb = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(computerbreadcrumb, "ComputerBreadcrumb", "No match");

	}
}
