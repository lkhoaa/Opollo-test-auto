package com.lkhoaa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class RetryClick {
    public static String retryClickUntilElementDisplayed(WebDriver driver, By clickLocator, By waitLocator, int maxRetries, long delayInMillis) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try {
                WebElement elementToClick = driver.findElement(clickLocator);
                elementToClick.click();

                // Wait for the other element to be displayed
                WebDriverWait wait = new WebDriverWait(driver, 10);
                WebElement displayedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(waitLocator));

                // Get and return the text of the displayed element
                return displayedElement.getText();
            } catch (NoSuchElementException | ElementNotInteractableException e) {
                attempts++;
                try {
                    Thread.sleep(delayInMillis);
                } catch (InterruptedException ignored) {}
            }
        }
        throw new RuntimeException("Failed to click the element and display the target element after " + maxRetries + " attempts");
    }

}
