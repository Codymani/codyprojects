package org.today;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class flipkartPage extends BaseClass {
	
	public static void flipkartLogin() throws InterruptedException {
		browsers("Chrome");
		urlLaunch("https://www.flipkart.com/");
		impWait(20);
		
		
		WebElement txtuser = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		txtuser.sendKeys("6385530965");
		Thread.sleep(2000);

		WebElement txtpassword = driver.findElement(By.xpath("//input[@type='password']"));
		txtpassword.sendKeys("moni301298");
		
		WebElement btnclick = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		btnclick.click();
		Thread.sleep(2000);
		
		WebElement Search = driver.findElement(By.name("q"));
		Search.sendKeys("Toys",Keys.ENTER);
	
	}
	public static List<String>  productName() {
		
		List<WebElement> productCount= driver.findElements(By.xpath("//a[@class='s1Q9rs']"));
		List<String>productList=new ArrayList<String>();
		for(WebElement x:productCount ) {
			productList.add(x.getText());

	}
//		System.out.println("List out product names"+productList);
		return productList;
		
		
	}	
	public static List<String>  productPrice() throws InterruptedException {
		List<WebElement> priceCount = driver.findElements(By.xpath("//div[@class='_30jeq3']"));
		List<String>priceList=new ArrayList<String>();
		for(WebElement x:priceCount ) {
			priceList.add(x.getText());

	}
//		System.out.println("List out price names"+priceList);
		
		WebElement next = driver.findElement(By.xpath("//span[text()='Next']"));
		next.click();
		Thread.sleep(3000);
		return priceList;
		
		
	}	
		

	}
	


