package example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class tes {
    public static void main(String[] args) throws InterruptedException { //method
        System.out.println("Hello world!");
        System.setProperty("webdriver.chrome.driver", //fungsi
                System.getProperty("user.dir")+ "\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String appUrl = "https://www.saucedemo.com/";
        driver.get(appUrl);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.xpath(" //input[@id='login-button']")).click();

        driver.findElement(By.xpath("//span[@class='title']")).isDisplayed();

        String verify = driver.findElement(By.xpath("//span[@class='title']")).getText();
        String expectedResult = "PRODUCTS";
        Assert.assertEquals(expectedResult, verify);

        Thread.sleep(2000);

        driver.quit();
    }
}