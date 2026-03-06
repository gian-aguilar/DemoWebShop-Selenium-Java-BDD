
# Demo Web Shop - E2E Automation Framework

## Project Overview

This project is an automated testing framework designed to validate the **End-to-End (E2E)** customer journey on the [Demo Web Shop](https://demowebshop.tricentis.com/) site.

The framework simulates real user behavior, covering critical business flows such as:

-   **User Authentication:** Login/Logout with valid and invalid credentials.
    
-   **Product Discovery:** Searching for items.
    
-   **Purchase Items:** Adding items to the cart and completing the checkout.
    

----------

## Tech Stack

-   **Language:** Java
    
-   **Automation Tool:** Selenium WebDriver
    
-   **BDD Framework:** Cucumber (Gherkin)
    
-   **Build Tool:** Maven
    
-   **Test Runner:** JUnit
    
-   **Design Pattern:** Page Object Model (POM)
    

----------


## 🚀 How to Run Tests

1.  **Prepare Test Data:** Open `src/test/resources/features/EndtoEnd.feature` and ensure the `Examples:` table contains the valid **username** and **password** for the Demo Web Shop.
    
2.  **Execution:** Run via terminal:    
       
    ```
    mvn clean test    
    ```
3. **Execution via IDE:** Right-click `src/test/java/testrunner/TestRunner.java` and select **Run as JUnit Test**. _(Note: Ensure the `@HappyPath` tag is present in the Runner to execute the E2E flow.)_

    
4.  **Reporting:** Once the execution finishes, the **Standard Cucumber HTML Report** is automatically generated.
    

----------

## Project Structure

```
├── src/test/java
│   ├── base            # DriverFactory (Browser management)
│   ├── hooks           # Global Setup/Teardown
│   ├── pages           # Page Object Model (BasePage & Page Classes)
│   ├── stepdefinitions # Glue code connecting Gherkin to Java
│   └── runners         # Cucumber JUnit Test Runner
├── src/test/resources
│   ├── features        # BDD Scenarios
│   └── config.properties # Global settings (URL, Browser, Timeout)

```

----------

## Test Results & Reporting

The framework generates a standard HTML report for every execution.

-   **Location:** `target/cucumber-reports.html`
    
-   **Features:** Includes step-by-step pass/fail status and execution time for each scenario.
    

> _[Note: Open the file in any browser to view the visual results.]_

----------

## Why I Built This

I built this to demonstrate a clean, maintainable approach to test automation.

-   **Explicit over Implicit:** I avoided the "mixing waits" pitfall by using **WebDriverWait** exclusively in the `BasePage`. This ensures the framework is fast without flaky failures.
    
-   **Centralized Configuration:** All environment variables are stored in `config.properties`, making the framework easily portable between local and staging environments.
    
-   **Single-Session Driver:** Using a `DriverFactory` ensures a clean browser instance for every scenario, preventing "dirty data" from leaking between tests.

"The framework currently utilizes **Data-Driven Testing** via Gherkin `Scenario Outlines`, allowing for easy visualization of test data directly within the requirements."
