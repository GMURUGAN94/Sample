package com.maventest;


import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.Element;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	
	WebDriver driver;

	public void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public void loadUrl(String url) {
		driver.get(url);
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public void type(WebElement element, String data) {
		element.sendKeys(data);
	}

	public void click(WebElement element) {
		element.click();
	}

	public WebElement findElementById(String data) {
		WebElement element = driver.findElement(By.id(data));
		return element;
	}

	public WebElement findElementByName(String data) {
		WebElement element = driver.findElement(By.id(data));
		return element;
	}

	public WebElement findElementByClassName(String data) {
		WebElement element = driver.findElement(By.id(data));
		return element;
	}

	public WebElement findElementByXpath(String data) {
		WebElement element = driver.findElement(By.id(data));
		return element;
	}

	public String getEnteredUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public String getTitile() {
		String title = driver.getTitle();
		return title;
	}

	public String getText(WebElement element) {
		String data = element.getText();
		return data;
	}

	public String getAttribute(WebElement element, String attributeName) {
		String data = element.getAttribute(attributeName);
		return data;
	}

	public String getAttribute(WebElement element) {
		String data = element.getAttribute("value");
		return data;
	}

	public void selectOptionByText(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByVisibleText(data);
	}

	public void selectOptionByAttribute(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByValue(data);
	}
	
	public void selectoptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void typeJs(WebElement element, String data) {
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','"+data+"')",element);
	}
	
	public void switchToFrameById(String frameId) {
		driver.switchTo().frame(frameId);
	}
	
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrameByElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void closeCurrentTab() {
		driver.close();
	}
	
	public void closeAllTabs() {
		driver.quit();
	}
	public void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public String getData(String sheetName, int rowIndex, int cellIndex) throws IOException {
		File file = new File("C:\\Users\\Administrator\\Desktop\\Coginizant\\Workspace\\Maven\\Excel\\Datas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		int cellType = cell.getCellType();
		if (cellType==1) {
			String data = cell.getStringCellValue();
			return data;
		}
		else {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd=MMM-yy");
				String data = dateFormat.format(dateCellValue);
				return data;
			}
			else {
				 double d = cell.getNumericCellValue();
				 long l = (long)d;
				 String data = String.valueOf(l);
				 return data;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
