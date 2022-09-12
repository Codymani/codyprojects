package org.today;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ContextClickAction;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;




public class BaseClass {
	
	  public static	 WebDriver driver;
	//1
//	public static WebDriver chromeLaunch() {
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		return driver;
//	}

	
	public static void browsers(String browserName) {
		 String brName= browserName;
		 switch(brName) {
		 case"Chrome":
			 WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
		 case"IE":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
			
		 case"Edge":
			 WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				break;
		 case"FireFox":
			 WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				break;
		 }

	}
	
	
	
//	2
	public static void urlLaunch(String url) {
		driver.get(url);
	}
	
//	3
	public static void impWait(int sec) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
		
	}
//	4
	public static  void sendKeys(WebElement w,String keys) {
		
		w.sendKeys(keys);
	}
	//4.another way sendkeys
	
//	5
	public static void click(WebElement w) {
		w.click();
	}
	
//6	
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
//7	
	public static String getTitle() {
		String title = driver.getTitle();
		return title;

	}
	
//8	
	public static String getText(WebElement a) {
		String text = a.getText();
		return text;
	}
	
//9	
	public static String getAttributeText(WebElement a) {
		String attText = a.getAttribute("innerText");
		return attText;
		
	}
//	10
	
	public static String getAttributeValue(WebElement a) {
		String attValue = a.getAttribute("value");
		return attValue;
		
	}
	
//	11
	public static void quit() {
		driver.quit();
	}
	
//	12
	
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}
	
	
//	13
	public static void forward() {
		driver.navigate().forward();
	}
	
//	14
	
	public static void back() {
		driver.navigate().back();
	}
	
//	15
	
	public static void refesh() {
		driver.navigate().refresh();
	}
	
//	16
	
	public static void clear(WebElement a) {
		a.clear();
	}
// 17	
	
	public static boolean isEnable(WebElement a) {
		boolean enabled = a.isEnabled();
		return enabled;
		
	}
	
//	18
	public static boolean isDisplayed(WebElement a) {
		boolean displayed = a.isDisplayed();
		return displayed;
	}
//	19
	public static boolean isSelected(WebElement a) {
		boolean selected = a.isSelected();
		return selected;
	}	
	
//	20
	public static void getScreenshortAs(String name) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File from = ts.getScreenshotAs(OutputType.FILE);
		File to=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\ScreenShort\\"+name+".png");
		FileUtils.copyFile(from, to);
		
	}
//	21
	public static void moveToElementAction(WebElement target) {
		Actions a =new Actions(driver);
		a.moveToElement(target).perform();
	}
//	22
	public static  void dragAndDropAction(WebElement from,WebElement to) {
		Actions a =new Actions(driver);
		a.dragAndDrop(from, to).perform();
	}
		
//	23	
	public static void clickAction(WebElement target) {
		Actions a =new Actions(driver);
		a.click(target).perform();
	}	
		
//	24
	public static void clickMoveReleaseAction(WebElement from,WebElement to) {
		Actions a =new Actions(driver);
		a.clickAndHold(from).moveToElement(to).release().perform();
	}
		
//	25
	public static void clickAndReleaseAction(WebElement from, WebElement to) {
		Actions a =new Actions(driver);
		a.clickAndHold(from).release(to).perform();

	}
	
//26		
	public static void doubleClickAction(WebElement target) {
		Actions a =new Actions(driver);
		a.doubleClick(target).perform();
	}	
//27
	public static void tripleClickAction(WebElement target) {
		Actions a =new Actions(driver);
		a.doubleClick(target).click().perform();
	}
		
//28		
	public static void ContextClickAction(WebElement target) {
		
		Actions a =new Actions(driver);
		a.contextClick(target).perform();
		
	}	
		
//29
	public static void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
		
//30
	public static void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
		
//31
	public static void promtAlertAccept(String keysToSend) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(keysToSend);
		alert.accept();
	}
		
//32
	public static void promtAlertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
//33
	
	public static void selectByIndex(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	
	}
		
//	34
	public static void selectByValue(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
		
//35		
	public static void selectByVisibleText(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
		
//	36
	
	public static void deSelectByIndex(WebElement element,int index) {
		Select sel=new Select(element);
		sel.deselectByIndex(index);
	}
		
//	37
	
	public static void deSelectByValue(WebElement element,String value) {
		Select sel=new Select(element);
		sel.deselectByValue(value);
		
	}
	
//	38
	
	public static void deSelectByVisibleText(WebElement element, String text) {
		Select sel=new Select(element);
		sel.deselectByVisibleText(text);
	}
	
//	39
	
	public static void deSelectAll(WebElement element) {
		Select sel=new Select(element);
		sel.deselectAll();
	}
		
//	40
	
	public static  boolean isMultiple(WebElement element) {
		Select sel=new Select(element);
		boolean multiple = sel.isMultiple();
		return multiple;
	}
	
//	41
	
	public static void getOptions(WebElement element) {
		Select sel=new Select(element);
		List<WebElement> options = sel.getOptions();
		for(WebElement x:options) {
			String text = x.getText();
			System.out.println(text);
		}
	}
	
//	42
	public static String getFirstSelectedOption(WebElement element) {
		Select sel=new Select(element);
		WebElement selectedOption = sel.getFirstSelectedOption();
		String text = selectedOption.getText();
		return text;
		
	}
		
//	43
	
	public static void getAllSelectedOption(WebElement element) {
		Select sel=new Select(element);
		List<WebElement> allSelectedOptions = sel.getAllSelectedOptions();
		for(WebElement x:allSelectedOptions) {
			String text = x.getText();
			System.out.println(text);
		}
	}

//	44
	
	public static void frameByIndex(WebElement index) {
		driver.switchTo().frame(index);

	}
	
//	45
	
	public static void frameByIdOrName(WebElement nameOrId) {
		driver.switchTo().frame(nameOrId);
		
	}
	
//	46
	
	public static void frameByWebElement(WebElement frameElement ) {
		driver.switchTo().frame(frameElement);
	}
	
//	47
	
	public static void defaultContent() {
		driver.switchTo().defaultContent();

	}
	
//	48
	
	public static void parentFrame() {
		driver.switchTo().parentFrame();
		
	}
	
	
//	49
	
	public static void setExecuteScript(String text ,WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].setAttribute('value','"+text+"')",element);
	}
	
	
//50	
	public static String getExecuteScript(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver; 
		Object executeScript = js.executeScript("return arguments[0].getAttribute('value')",element);
		String data =(String)executeScript;
		return data;
	}
	
//51
	public static void scrollDown(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView('true')", element);
	}
	
	
//	52
	public static void scrollUp(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView('false')", element);
	}
	
//	53
	public static void windowHandles(int index) {
		Set<String> allid = driver.getWindowHandles();
		List<String> li=new ArrayList<String>();
		li.addAll(allid);
		driver.switchTo().window(li.get(index));

	}
	
//	54 FindElement
	public static WebElement findElement(String locatorName,String locatorValue) {
		WebElement value=null;
		if(locatorName.equals("id")) {
			 value = driver.findElement(By.id(locatorValue));
			
		}else if(locatorName.equals("name")) {
			value = driver.findElement(By.name(locatorValue));
			
		}else if(locatorName.equals("xpath")) {
			value = driver.findElement(By.xpath(locatorValue));
		}
		return value;
	}
	
//	public static  String getExcelData(String filename,String Sheetname,int rowNO,int cellNo) throws IOException {

//		//File Path
//		File loc=new File("C:\\Users\\welcome\\Documents\\Project\\MavenProjectFirstDay\\src\\test\\resources\\Excel\\"+filename+".xlsx");
//		
//		//File InputStrem
//		FileInputStream st=new FileInputStream(loc);
//	
		//work book
//		
//		Workbook w=new XSSFWorkbook(st);
//		
////		sheet
//		Sheet sheet = w.getSheet(Sheetname);
//		
////		row
//		Row row = sheet.getRow(rowNO);
////		cell
//		Cell cell = row.getCell(cellNo);
//		System.out.println(cell);
//		
////celltype
//		int type = cell.getCellType();
//		String value=null;
//		if (type==1) {
//			 value = cell.getStringCellValue();
//		}
//		else {
//			if (DateUtil.isCellDateFormatted(cell)) {
//				Date date = cell.getDateCellValue();
//				SimpleDateFormat sf=new SimpleDateFormat("dd-mmm-yyyy");
//				 value = sf.format(date);
//			}
//			else {
//				double db = cell.getNumericCellValue();
//				long num=(long)db;
//				 value = String.valueOf(num);		 
//			}
//		}
//		return value;
//	}
//	
//	
//	public static void waits(WebElement element) {
//		WebDriverWait w=new WebDriverWait(driver,500);
//		w.until(ExpectedConditions.visibilityOf(element));
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
	
	}	

	