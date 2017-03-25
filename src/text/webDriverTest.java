package text;

import webdriver.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class webDriverTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Start test!");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Text completed!");
	}
	
	@Test
	public void testMain() {
		webDriver driver=new webDriver();
		List<String> dataList=driver.importCsv(new File("data\\inputgit.csv"));
        if(dataList!=null && !dataList.isEmpty()){
        	
        int count=dataList.size()-1;
       for (int i=1; i<count+1; i++)    
          {
        	  String s=new String(dataList.get(i));	  
        	  assertEquals(driver.getUrl(s),driver.testEqual(driver.getNumber(s),driver.getName(s),driver.getUrl(s))); 
          }   	
        }		
	}
}
