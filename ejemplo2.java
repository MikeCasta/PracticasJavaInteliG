package org.testerfabrik.basico;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ejemplo2 {
    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static void main (String[] args){
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        String baseUrl = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebDriverWait waitVar = new WebDriverWait(driver, 10);



        try {

            driver.switchTo().frame("iframeResult");

            WebElement btnTry = driver.findElement(By.xpath("/html/body/button"));
            waitVar.until(ExpectedConditions.elementToBeClickable(btnTry));
            btnTry.click();
            Thread.sleep(2000);

            waitVar.until(ExpectedConditions.alertIsPresent());
            Alert alrWindow = driver.switchTo().alert();
            String alertText = alrWindow.getText();
            System.out.println(alertText);
            alrWindow.sendKeys("Miguel C");
            alrWindow.accept();

            String finalText = driver.findElement(By.id("demo")).getText();
            System.out.println(finalText.contains("Miguel")?finalText:"Prueba Fallida");



        }catch (NoSuchElementException ne) {
            System.err.println("No se encontro el Webelement: " + ne.getMessage());
        }catch (NoSuchFrameException nf) {
            System.err.println("No se encontro el Frame: " + nf.getMessage());

        }catch (NoAlertPresentException na) {
            System.err.println("No se encontro la alerta: " + na.getMessage());

        }catch (TimeoutException te) {
            System.err.println("El tiempo de espera excedio: " + te.getMessage());

        }catch (WebDriverException we) {
            System.err.println("Webelement fallo: " + we.getMessage());
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
        }finally {
            driver.quit();
        }
    }
}
