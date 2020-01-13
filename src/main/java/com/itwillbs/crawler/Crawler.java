package com.itwillbs.crawler;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import com.itwillbs.domain.ArticleBean;
import com.itwillbs.domain.CrawlerBean;

public class Crawler {
	private WebDriver driver;

	@Test
	public List<ArticleBean> crawling(CrawlerBean cb, String path) {
		
		List<ArticleBean> jList = new ArrayList<ArticleBean>();
		
		// Optional. If not specified, WebDriver searches the PATH for chromedriver.
		System.setProperty("webdriver.chrome.driver",
				path+"/resources/driver/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		for(int i = 0; i<cb.getPage(); i++) {
			driver.get("https://www.google.com/search?q="+cb.getKeyword()+"&tbm=nws&start="+(i*10));
			
			wait(2000);
			
			
			List<WebElement> elements = driver.findElements(By.className("gG0TJc"));

			for(WebElement e : elements) {
//				System.out.println("subject = "+e.findElement(By.className("lLrAF")).getText());//subject
//				System.out.println("link = "+e.findElement(By.className("lLrAF")).getAttribute("href"));//link
//				
//				System.out.println("press = "+e.findElement(By.className("xQ82C")).getText());//press
//				System.out.println("date = "+e.findElement(By.className("fwzPFf")).getText());//date
//				System.out.println("content = "+e.findElement(By.className("st")).getText());//content
				
				ArticleBean ab = new ArticleBean();
				
				ab.setSubject(e.findElement(By.className("lLrAF")).getText());
				ab.setLink(e.findElement(By.className("lLrAF")).getAttribute("href"));
				ab.setPress(e.findElement(By.className("xQ82C")).getText());
				ab.setDate(e.findElement(By.className("fwzPFf")).getText());
				ab.setContent(e.findElement(By.className("st")).getText());
				
				jList.add(ab);

			}
		}
		
//		searchBox.sendKeys("ChromeDriver");
//		searchBox.click();
		
		driver.quit();
		return jList;
	}
	
	
	public void wait(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Let the user actually see something!
	}

}