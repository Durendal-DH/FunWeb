package com.itwillbs.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import com.itwillbs.domain.ArticleBean;
import com.itwillbs.domain.CrawlerBean;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Crawler {
	private Document doc;

	@Test
	public List<ArticleBean> crawling(CrawlerBean cb, String path) {
		List<ArticleBean> jList = new ArrayList<ArticleBean>();
		
		for(int i = 0; i<cb.getPage(); i++) {
			try {
				doc = Jsoup.connect("https://search.naver.com/search.naver?query="+cb.getKeyword()+"&where=news&start="+(i*10+1)).get();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Elements news = doc.select(".type01 > li");
			
			
			for(Element e : news) {
//				System.out.println("=====");
				String img = e.select(".thumb img").attr("src");
				String subject = e.select("._sp_each_title").attr("title");
				String link = e.select("._sp_each_title").attr("href");
				String press = e.select("._sp_each_source").text();
				String date = e.select(".txt_inline ").text();
				date = date.substring(press.length()+1);
				if(date.contains("단")) {
					date = date.substring(date.lastIndexOf("단")+2);
				}
				if(date.contains(" 전")) {
					date = date.substring(0,date.lastIndexOf(" 전")+2);
				}else {
					date = date.substring(0,11);
				}
				String content = e.select("dd").get(1).text();
//				System.out.println("img = "+img);
//				System.out.println("subject = "+subject);
//				System.out.println("link = "+link);
//				System.out.println("press = "+press);
//				System.out.println("date = "+date);
//				System.out.println("content = "+content);
//				System.out.println("=====");

				
				ArticleBean ab = new ArticleBean();
				
				ab.setImg(img);
				ab.setSubject(subject);
				ab.setLink(link);
				ab.setPress(press);
				ab.setDate(date);
				ab.setContent(content);
				
				jList.add(ab);

			}
		}
		
		
		return jList;
	}
	
//	@Test
//	public List<ArticleBean> crawling(CrawlerBean cb, String path) {
//		List<ArticleBean> jList = new ArrayList<ArticleBean>();
//		WebDriverManager.chromedriver().setup();
////		wdm.chromeDriverUrl=https://chromedriver.storage.googleapis.com/
////			wdm.chromeDriverExport=webdriver.chrome.driver
////			wdm.chromeDriverVersion=LATEST
////			ChromeDriverManager.getInstance().setup();
//			driver = new ChromeDriver();
//		// Optional. If not specified, WebDriver searches the PATH for chromedriver.
////		System.setProperty("webdriver.chrome.driver",
////				path+"/resources/driver/chromedriver.exe");
////		
////		driver = new ChromeDriver();
//		
//		for(int i = 0; i<cb.getPage(); i++) {
//			driver.get("https://www.google.com/search?q="+cb.getKeyword()+"&tbm=nws&start="+(i*10));
//			
//			wait(2000);
//			
//			
//			List<WebElement> elements = driver.findElements(By.className("gG0TJc"));
//
//			for(WebElement e : elements) {
////				System.out.println("subject = "+e.findElement(By.className("lLrAF")).getText());//subject
////				System.out.println("link = "+e.findElement(By.className("lLrAF")).getAttribute("href"));//link
////				
////				System.out.println("press = "+e.findElement(By.className("xQ82C")).getText());//press
////				System.out.println("date = "+e.findElement(By.className("fwzPFf")).getText());//date
////				System.out.println("content = "+e.findElement(By.className("st")).getText());//content
//				
//				ArticleBean ab = new ArticleBean();
//				
//				ab.setSubject(e.findElement(By.className("lLrAF")).getText());
//				ab.setLink(e.findElement(By.className("lLrAF")).getAttribute("href"));
//				ab.setPress(e.findElement(By.className("xQ82C")).getText());
//				ab.setDate(e.findElement(By.className("fwzPFf")).getText());
//				ab.setContent(e.findElement(By.className("st")).getText());
//				
//				jList.add(ab);
//
//			}
//		}
//		
////		searchBox.sendKeys("ChromeDriver");
////		searchBox.click();
//		
//		driver.quit();
//		return jList;
//	}
	
	
	public void wait(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Let the user actually see something!
	}

}