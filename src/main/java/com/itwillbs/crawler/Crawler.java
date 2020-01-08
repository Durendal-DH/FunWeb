package com.itwillbs.crawler;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import com.itwillbs.domain.CrawlerBean;

public class Crawler {
   private WebDriver driver;

   @Test
   public void crawling(CrawlerBean cb, String path) {
      // Optional. If not specified, WebDriver searches the PATH for chromedriver.
      System.setProperty("webdriver.chrome.driver",
            path+"/resources/driver/chromedriver.exe");
      ChromeOptions option = new ChromeOptions();
      option.addArguments("headless");
      
      WebDriver driver = new ChromeDriver(option);
      driver.get("http://www.google.com/");
      
      WebElement searchBox = driver.findElement(By.name("q"));
      searchBox.sendKeys("ChromeDriver");
      searchBox.submit();
      wait(5000);
      driver.quit();
   }
   
   public void wait(int n){
	   try {
	         Thread.sleep(n);
	      } catch (InterruptedException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } // Let the user actually see something!
   }

}