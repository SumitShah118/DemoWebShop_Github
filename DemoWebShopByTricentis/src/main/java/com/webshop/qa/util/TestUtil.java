package com.webshop.qa.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.webshop.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static void validateBrokenLink() {
		String webpage = "http://demowebshop.tricentis.com/";
		String url="";
		HttpURLConnection huc;
		int respCode = 200;
		
		driver.get(webpage);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> itr = links.iterator();
		while(itr.hasNext()) {
			url = itr.next().getAttribute("href");
			
			if(url == null || url.isEmpty()) {
				System.out.println("URL is neither configured for anchor tag or it is empty");
				continue;
			}else if(!url.startsWith(webpage)) {
				System.out.println("URL is belongs to different domain, skipping it");
				continue;
			}else {
				try {
					huc = (HttpURLConnection)(new URL(url).openConnection());
					huc.setRequestMethod("HEAD");
					huc.connect();
					respCode = huc.getResponseCode();
					if(respCode >= 400) {
						System.out.println(url + "This URL is Broken");
					}else {
						System.out.println(url + "This is Valid URL");
					}
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
	}
}
