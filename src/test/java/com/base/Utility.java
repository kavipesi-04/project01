package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {
	
	public static WebDriver driver;
	
	public  void browserLaunch(String url) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.get(url);
		
	}
	
	public void verifyLogin() {

		String invalidUrl ="https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=100";
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.equalsIgnoreCase(invalidUrl))
		{
			System.out.println("Invalid user");
		}
	}
	public String getUserNameData(int row,int col) throws IOException {

		File f=new File("C:\\Users\\AISHWARYA\\cucumFrame\\testData\\fbLogin.xlsx");
		FileInputStream fIn=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fIn);
		Sheet s= wb.getSheet("login");
		Row r = s.getRow(row);
		Cell c = r.getCell(col);
		return c.getStringCellValue();
	}
	
	public String getPasswordData(int row,int col) throws IOException {

		File f=new File("C:\\Users\\AISHWARYA\\cucumFrame\\testData\\fbLogin.xlsx");
		FileInputStream fIn=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fIn);
		Sheet s= wb.getSheet("login");
		Row r = s.getRow(row);
		Cell c = r.getCell(col);
		double d = c.getNumericCellValue();
		Long l=(long)d;
		String str=String.valueOf(l);
		return str;
	}

}
