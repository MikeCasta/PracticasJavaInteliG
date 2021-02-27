package org.testerfabrik.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseQuit {
    static WebDriver driver;   //variables
    static String baseURL = "http://testautomationpractice.blogspot.com/";
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    //Metodos close y quit
    public static void close () throws InterruptedException {
        driver = new ChromeDriver();
        driver.navigate().to(baseURL);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("//*[@id=\"HTML9\"]/div[1]/button")).click();
        Thread.sleep(2000);
        driver.close();
    }

    public static void quit () throws InterruptedException {
        driver = new ChromeDriver();
        driver.get(baseURL);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button")).click();
        Thread.sleep(2000);
        driver.quit();
    }
    public static void main (String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath);
        quit();
    }

}
