package com.browserstack.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.junit.Assert.assertEquals;

public class SearchSteps {
    private WebDriver driver;

    @Before
    public void setUp(Scenario scenario) throws Exception {
        String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
        String ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
        String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub.browserstack.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", System.getProperty("browser"));
        caps.setCapability("browser_version", System.getProperty("browser_version"));
        caps.setCapability("os", System.getProperty("os"));
        caps.setCapability("os_version", System.getProperty("os_version"));
        caps.setCapability("resolution", System.getProperty("resolution"));
        caps.setCapability("build", "SE Cucumber Tests V1");
        caps.setCapability("project", "SE Cucumber Tests");

        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @Given("^Enter search term '(.*?)'$")
    public void searchFor(String searchTerm) {
        driver.navigate().to("http://en.wikipedia.org");
        WebElement searchField = driver.findElement(By.id("searchInput"));
        searchField.sendKeys(searchTerm);
    }

    @When("^Do search$")
    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        searchButton.click();
    }

    @Then("^Single result is shown for '(.*?)'$")
    public void assertSingleResult(String searchResult) {
        assertEquals("Cucumber - Wikipedia", driver.getTitle());
    }

    @After
    public void teardown() throws Exception {
        driver.quit();
    }
}
