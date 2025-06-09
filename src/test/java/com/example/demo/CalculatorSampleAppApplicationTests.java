package com.example.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.*;

public class CalculatorSampleAppApplicationTests {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:/Windows/chromedriver.exe");

        // Optional: Add Chrome options if needed
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("http://localhost:8080"); // Replace with your actual app URL
    }

    @Test
    public void testAddition() throws InterruptedException {
        // Enter 2 in left operand
        WebElement leftOperand = driver.findElement(By.name("leftOperand"));
        leftOperand.clear();
        leftOperand.sendKeys("2");

        // Enter 3 in right operand
        WebElement rightOperand = driver.findElement(By.name("rightOperand"));
        rightOperand.clear();
        rightOperand.sendKeys("3");

        // Select '+' operator
        WebElement operator = driver.findElement(By.name("operator"));
        operator.sendKeys("+");

        // Click Calculate
        WebElement calculateBtn = driver.findElement(By.xpath("//button[text()='Calculate']"));
        calculateBtn.click();

        // Optional: wait for result to update
        Thread.sleep(2000);

        // Check the result
        WebElement result = driver.findElement(By.id("result"));
        String resultText = result.getText();

        assertEquals("6", resultText.trim());
    }

    // @After
    // public void tearDown() {
    // driver.quit();
    // }
    @Test
    public void failingTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080");

        // Intentionally fail by asserting wrong title
        String title = driver.getTitle();
        assertEquals("ThisIsWrongTitle", title);

        driver.quit();
    }
}
