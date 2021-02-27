package org.testerfabrik.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverException {
    static WebDriver driver;
    public static void main(String[] args) {

        try{
            String baseURL = "http://live.demoguru99.com/index.php/checkout/cart";
            String actualResult = "";
            String expectedResult = "$615.00";
            String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
            driver.get(baseURL);
            driver.manage().window().maximize();

            //dar clic en link TV
            //Crear un objeto de tipo webElement, se elimina la acción cuando se declara un web element
            WebElement inkTV = driver.findElement(By.linkText("TV"));
            inkTV.click();

            //Click en boton ADD TO CAR
            //Crear un objeto de tipo webElement, se elimina la acción cuando se declara un web element
            WebElement btnAddToCart = driver.findElement(By.xpath("//*[@id=\"to\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span"));
            btnAddToCart.click();

            //obtener el precio de ese objeto
            //Crear un objeto de tipo webElement, se elimina la acción cuando se declara un web element
            WebElement Ib1subtotal = driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-total > span > span"));
            actualResult = Ib1subtotal.getText();

            if (actualResult.contentEquals(expectedResult)) {
                System.out.println("Prueba PASDA! el resultado actual es:  " + actualResult + " es igual a " + expectedResult);
            } else {
                System.out.println("Prueba FALLO! el resultado actual es:  " + actualResult + "no es igual a " + expectedResult);
            }
            //primer exception que no se encontro elemento, es para un webelement Itb1subtotal
        }catch (NoSuchElementException ne){   //nombre de variable "ne"
            System.err.println("No se encontro el Webelement: " + ne.getMessage()); //"err "cambia el color del mensaje

            //Segunda exception mas generica de es de webdriver exception, exception padre, si el error es de web driver
            //por ejemplo que el navegador tuvo una interrupción o fallo al iniciar el webdriver
        }catch (org.openqa.selenium.WebDriverException we){
            System.err.println("Webdriver Fallo: " + we.getMessage());

            //tercer Exception padre de todas las exceptiones sino tiene que ver con webdriver, si es error de sintaxsis o algo
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
        finally{
            driver.close();
        }
    }
}

