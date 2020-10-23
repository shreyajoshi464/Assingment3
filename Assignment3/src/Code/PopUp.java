package Code;

import java.util.Iterator;
import java.util.Set;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUp {
	WebDriver dr;
	String url="http://popuptest.com/goodpopups.html";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.get(url);
		dr.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		//dr.quit();
	}

	@Test
	public void test() {
		dr.findElement(By.linkText("Good Pop up#1")).click();
		
		Set<String>hand=dr.getWindowHandles();
		
		Iterator<String>s=hand.iterator();
		
		String parent =s.next();
		String child = s.next();
		
		
		dr.switchTo().window(child);
		
		System.out.println("Child win title"+dr.getTitle());
		
		dr.switchTo().window(parent);
		
		System.out.println("Parent win title"+dr.getTitle());
		
		
		
	}

}
