package com.test;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;



import java.util.List;

import java.util.Set;



public class OpenFlipkart {



    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.flipkart.com");

        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.name("q"));

        searchBox.sendKeys("iphone 15 pro max");

        searchBox.submit();



        String mainPage = driver.getWindowHandle();

        System.out.println("Main page=" + mainPage);



        driver.findElement(By.xpath("//div[contains(text(),'Apple iPhone 15 Pro Max (Blue Titanium, 256 GB)')]")).click();



        Set<String> allPages = driver.getWindowHandles();

        for (String page : allPages) {

            if (!page.equals(mainPage)) {

                driver.switchTo().window(page);

                break;

            }

        }



        System.out.println(driver.getCurrentUrl());



        List<WebElement> products = driver.findElements(By.className("_21Ahn-"));

        System.out.println(products.size());

        for (WebElement product : products) {

            System.out.println(product.getText());

        }



        driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();



        // Sleep to give some time for the product to be added to the cart

        try {

            Thread.sleep(2000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }



        // Click on the "Place Order" button

        driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();

        driver.findElement(By.cssSelector("._2IX_2-._17N0em")).sendKeys("aniruddhsingh79012@gmail.com");

        driver.findElement(By.xpath("//button[@type='submit']")).click();



        //driver.findElement(By.className("_2IX_2- _17N0em")).sendKeys("aniruddhsingh79012@gmail.com");

        //driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("pa55word");

        //driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();

    }

}
