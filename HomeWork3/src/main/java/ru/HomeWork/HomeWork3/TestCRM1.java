package ru.HomeWork.HomeWork3;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

class TestCRM1 {

    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "user";
    private static final String STUDENT_PASSWORD = "1234";
    private static final WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void main(String[] args) throws InterruptedException {

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
        WebDriverWait waitFiveSeconds = new WebDriverWait(driver, 5);
        waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(
                "div[class='pull-left btn-group icons-holder']"))));

        //Наименование

        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("/create"));
        driver.findElement(By.xpath(".//input[@name='crm_project[name]']")).sendKeys("Name");

        //Выбор организации
        driver.findElement(By.cssSelector("div['class=\"select2-choice select2-default\"']")).click();
        driver.findElement(By.name("crm_project[company]")).sendKeys("111");

//Подразделение
        Select businessUnitDropDown = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitDropDown.selectByValue("1");
        System.out.println("Select: " + businessUnitDropDown.getFirstSelectedOption().getText());

        //Куратор
        Select curatorDropDown = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorDropDown.selectByValue("38");

        //Руководитель
        Select rpDropDown = new Select(driver.findElement(By.name("crm_project[rp]")));
        rpDropDown.selectByValue("61");
        //Менеджер
        Select managerDropDown = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerDropDown.selectByValue("31");

        driver.findElement(By.cssSelector("button[class='btn btn-success action-button']")).click();
    }
}