package com.example;


import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class AppTest 
{
    WebDriver driver;
    @BeforeTest
    public void shouldAnswerWithTrue() throws Exception
    {
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
        driver.get("https://www.barnesandnoble.com/");
    }
    @Test(priority = 1)
    public void first() throws Exception
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[1]/a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[1]/div/a[2]"))).click();
        FileInputStream fs=new FileInputStream("C:\\Users\\rohit\\Downloads\\chetan.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(fs);
        XSSFSheet chetan=wb.getSheet("Chetan");
        XSSFRow row=chetan.getRow(0);
        String bookname=row.getCell(0).getStringCellValue();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[2]/div/input[1]"))).sendKeys(bookname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/span"))).click();
        WebElement text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div/div/section[1]/section[1]/div/div[1]/div[1]/h1/span")));
        String mytext=text.getText();
        if(mytext.equalsIgnoreCase("Chetan Bhagat"))
        {
            System.out.println(true);
        }
        else{
            System.out.println(false);
            
        }
    }
    @Test(priority = 2)
    public void three()
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        driver.navigate().to("https://www.barnesandnoble.com/membership/");
        js1.executeScript("window.scrollBy(0,2000)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section/div[1]/div[2]/div/div/div[2]/div/div[73]/div/div[1]/a"))).click();
        WebElement frame=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/iframe")));
        driver.switchTo().frame(frame);
        WebElement text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/h2")));
        String mytext=text.getText();
        if(mytext.equalsIgnoreCase("Sign in or Create an Account"))
        {
            System.out.println(true);
        }
        else{
            
            System.out.println(false);
        }
    }

}

