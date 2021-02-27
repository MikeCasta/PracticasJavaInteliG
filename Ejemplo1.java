package org.testerfabrik.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo1 {
    public static void main(String[] args){
        //intanciar un objeto webdriver
        WebDriver driver;

        //declarar variables
        String baseURL = "https://www.google.com/";
        String actualResult = "";
        String expectedResult = "Google";

        //Indicar la localizacion del archivo chrome.exe en la propiedad webdriver.chrome.driver
        //System.getProperty("user.dir") = C:\..\..\..\SeleniumBasico
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        //Abrir el navegador Chrome
        driver = new ChromeDriver();

        //Navegar a la pagina
        driver.get(baseURL);

        //Obtener el titulo de la pagina web
        actualResult = driver.getTitle();

        //imprimir el resultado usando el operador termario
        System.out.println(actualResult.contentEquals(expectedResult)?"Prueba pasada! " + actualResult : "Prueba fallada");

        driver.close();


    }

}
