package org.testerfabrik.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Forms {
    static WebDriver driver;

    public static void main (String[] args){
        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        String baseURL = "http://testautomationpractice.blogspot.com/";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        try {
            Thread.sleep(4000);
            WebElement txtFirstName = driver.findElement(By.className(""));
            txtFirstName.sendKeys("Gil");
            Thread.sleep(1500);
            txtFirstName.clear();
            Thread.sleep(1500);
            txtFirstName.sendKeys("Miguel");

            driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-4\"]")).sendKeys("test Addres");

            //crear un objeto para seleccionar las opciones desplegables
            Select drpoountry = new Select(driver.findElement(By.xpath("//*[@id=\"RESULT_RadioButton-9\"]")));
            Thread.sleep(2000);
            drpoountry.selectByVisibleText("Afternoon");
            Thread.sleep(2000);

            WebElement txtCiti = driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-5\"]"));
            txtCiti.sendKeys("Mexico");
            txtCiti.submit();

            System.out.println("Prueba Exitosa! "+ driver.findElement(By.xpath("//*[@id=\"content\"]/text()")).getText());


        }catch (NoSuchElementException ne){
            System.err.println("No se encontro el Webelement: " + ne.getMessage());
        }catch (WebDriverException we){
            System.err.println("Webelement fallo: " + we.getMessage());
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            driver.quit();
        }
    }
}
