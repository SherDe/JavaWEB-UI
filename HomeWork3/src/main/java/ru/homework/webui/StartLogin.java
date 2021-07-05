package ru.homework.webui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class StartLogin {

    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "user";
    private static final String STUDENT_PASSWORD = "1234";
    private static WebDriver driver;


    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(LOGIN_PAGE_URL);

        WebElement loginTextInput = driver.findElement(By.xpath(".//input[@name='_username']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);
        Thread.sleep(3000);

        WebElement passwordTextInput = driver.findElement(By.xpath(".//input[@name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);
        Thread.sleep(3000);

        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(".//ul[@class='nav nav-multilevel main-menu']/li[@class='dropdown']/a[@class='unclickable']/span[text()='Проекты']")).click();
        driver.findElement(By.xpath(".//span[@class='title' and text()='Мои проекты']")).click();
        sleep(3000);
        driver.findElement(By.cssSelector("div[class='pull-left btn-group icons-holder']")).click();

        //Наименование
       sleep(2000);

        driver.findElement(By.xpath(".//input[@name='crm_project[name]']")).sendKeys("Name");


        //Организация
        sleep(2000);
        driver.findElement(By.xpath(".//a[@class='select2-choice select2-default']/span[@class='select2-chosen']")).click();

        //Подразделение
        sleep(2000);
        Select businessUnitDropDown = new Select(driver.findElement(By.name("crm_project_businessUnit")));
        businessUnitDropDown.selectByValue("1");
        System.out.println("Select: " + businessUnitDropDown.getFirstSelectedOption().getText());

    }

}