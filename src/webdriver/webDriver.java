package webdriver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webDriver {
	
	public static List<String> importCsv(File file){
        List<String> dataList=new ArrayList<String>();
        
        BufferedReader br=null;
        try { 
            br = new BufferedReader(new FileReader(file));
            String line = ""; 
            while ((line = br.readLine()) != null) { 
                dataList.add(line);
            }
        }catch (Exception e) {
        }finally{
            if(br!=null){
                try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return dataList;
    }
	
	public String getUrl(String s)
	{
		String number=s.substring(0,s.indexOf(","));
  	    String password=number.substring(4,number.length());
  	    int pos=s.indexOf(",")+1;
  	    int pos1=s.indexOf(",",pos);
  	    String name=s.substring(pos,pos1);
  	    String url=s.substring(pos1+1,s.length());

  	    return url;
	}
	public String getNumber(String s)
	{
		String number=s.substring(0,s.indexOf(","));
  	    return number;
	}
	public String getName(String s)
	{
		String number=s.substring(0,s.indexOf(","));
  	    String password=number.substring(4,number.length());
  	    int pos=s.indexOf(",")+1;
  	    int pos1=s.indexOf(",",pos);
  	    String name=s.substring(pos,pos1);
  	    return name;
	}
	
	public String testEqual(String number, String name, String url)
	{
		String password=number.substring(4,number.length());
	  	WebDriver dri = new FirefoxDriver();
  	    dri.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  	    dri.navigate().to("http://121.193.130.195:8080/");
  	    dri.findElement(By.id("name")).sendKeys(number);
  	    dri.findElement(By.id("pwd")).sendKeys(password);
  	    dri.findElement(By.id("submit")).click();
  	    String result=dri.findElement(By.xpath(".//*[@id='table-main']/tr[3]/td[2]")).getText();
  	    dri.close();  
  	    return result;	
	}
	
}


