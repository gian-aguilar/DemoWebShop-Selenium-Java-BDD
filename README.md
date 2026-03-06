# DemoWebShop Selenium BDD Framework
 

![Build Status](https://github.com/gian-aguilar/DemoWebShop-Selenium-Java-BDD/actions/workflows/maven.yml/badge.svg)

  
This is a Selenium-Java-Cucumber automation framework running on GitHub Actions.


## Project Overview

This project is an automated testing framework designed to validate the **End-to-End (E2E)** customer journey on the [Demo Web Shop](https://demowebshop.tricentis.com/) site. It demonstrates a professional approach to BDD (Behavior Driven Development) using Selenium and Java.

## Test Coverage

The framework covers both positive and negative functional flows:

-   **User Authentication:** Login/Logout with `@Login` (valid) and `@Invalid_Login` credentials.
    
-   **Product Discovery:** Searching for items and verifying results.
    
-   **Purchase Journey:** Adding items to the cart and completing the checkout process.
    

----------

## Tech Stack

-   **Language:** Java 17+
    
-   **Automation Tool:** Selenium WebDriver 4
    
-   **BDD Framework:** Cucumber (Gherkin)
    
-   **Build Tool:** Maven
    
-   **Test Runner:** JUnit 4
    
-   **Design Pattern:** Page Object Model (POM)
    
-   **CI/CD:** GitHub Actions
    

----------

## How to Run Tests

## **Local Execution**

1.  **Clone the repository:**
    
        
    ```
    git clone https://github.com/gian-aguilar/DemoWebShop-Selenium-Java-BDD.git
    
    ```
    
2.  **Run all tests via Terminal:**
    
        
    ```
    mvn clean test
    
    ```
    
3.  **Run specific suites using Tags:**
    
        
    ```
    mvn test -Dcucumber.filter.tags="@EndtoEnd"
    
    ```
    
4.  **Execution via IDE:** Right-click `src/test/java/testrunner/TestRunner.java` and select **Run as JUnit Test**. (The runner is configured to be tag-agnostic, allowing for full suite execution).
    

## **CI/CD Execution (GitHub Actions)**

This framework is fully automated in the cloud.

-   **Trigger:** Every `push` or `pull_request` to the `main` branch.
    
-   **Environment:** Runs on `ubuntu-latest` using **Chrome Headless** mode.
    
-   **Artifacts:** Cucumber HTML reports are generated and stored in the "Actions" summary after every run.
    

----------

## Project Structure

```
├── .github/workflows   # GitHub Actions CI/CD pipeline (maven.yml)
├── src/test/java
│   ├── base            # DriverFactory (Browser & Headless management)
│   ├── hooks           # Global Setup/Teardown (Screenshot capture)
│   ├── pages           # Page Object Model (BasePage & Page Classes)
│   ├── stepdefinitions # Glue code connecting Gherkin to Java
│   └── testrunner      # Dynamic Cucumber JUnit Test Runner
├── src/test/resources
│   ├── features        # BDD Scenarios (Gherkin)
│   └── config.properties # Global settings (URL, Browser, Timeout)

```

----------

## Reporting

The framework generates a detailed HTML report for every execution.

-   **Local:** `target/cucumber-reports.html`
-   **GitHub Actions:** Download the `cucumber-report` artifact from the **Summary** page of any successful run.
    
-   **Features:** Includes step-by-step pass/fail status, execution time, and Gherkin formatting.
    

----------

## Why I Built This

I built this to demonstrate a clean, maintainable approach to test automation:

-   **Robust Browser Management:** The `DriverFactory` supports both local (UI) and CI (Headless) execution dynamically.
    
-   **Scalable Configuration:** Utilizes a multi-layered approach to configuration. It reads from `config.properties` but allows **System Property Overrides** via Maven (e.g., `-Dbrowser=firefox`).
    
-   **Explicit Waits:** I avoided "Thread.sleep" or mixing implicit/explicit waits. I implemented `WebDriverWait` within a `BasePage` to ensure the framework is fast and resilient against flakiness.
    
-   **Clean CI/CD Integration:** Integrated with GitHub Actions to ensure code quality is verified automatically on every commit.
- "The framework currently utilizes **Data-Driven Testing** via Gherkin `Scenario Outlines`, allowing for easy visualization of test data directly within the requirements."
