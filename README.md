# DemoWebShop Selenium Java BDD Automation Framework
![Build Status](https://github.com/gian-aguilar/DemoWebShop-Selenium-Java-BDD/actions/workflows/maven.yml/badge.svg)
 


This project demonstrates a test automation framework built using Selenium WebDriver, Java, and Cucumber (BDD) to automate functional test scenarios for the Demo Web Shop application.  
  
The goal of this project is to showcase modern QA automation practices including Page Object Model (POM), Behavior Driven Development (BDD), and CI/CD integration using GitHub Actions.  
  
Test Target:  
https://demowebshop.tricentis.com/  
  
---  
  
## Tech Stack  
  
- Java  
- Selenium WebDriver  
- Cucumber BDD  
- Maven  
- JUnit  
- Git  
- GitHub Actions (CI/CD)  
  
---  
  
## Framework Architecture  
  
The framework follows the Page Object Model (POM) design pattern to improve test maintainability and scalability.  
  
Project structure:  

```
├── .github/workflows 
├── src/test/java
│   ├── base            
│   ├── hooks           
│   ├── pages           
│   ├── stepdefinitions 
│   └── testrunner      
├── src/test/resources
│   ├── features        
│   └── config.properties 
```

  
Key components:  
  
Page Objects 
Encapsulates web element locators and page actions.  
  
Step Definitions   
Maps Cucumber feature steps to automation code.  
  
Feature Files   
BDD scenarios written in Gherkin language.  
  
Test Runner   
Executes test scenarios using Cucumber and JUnit.  
  
---  
  
## Sample Automated Scenarios  
  
The following functional scenarios are automated:  
  
- User login with valid credentials  
- User login with invalid credentials  
- Search product catalog  
- Add product to shopping cart  
- Checkout cart contents
- User logout  
  
---  
  

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

  
---  
  
## Continuous Integration (CI)  
  
This project uses **GitHub Actions** to automatically run automation tests whenever code is pushed to the repository.  
  
CI workflow includes:  
  
- Project build  
- Dependency installation  
- Test execution using Maven  
- Automated validation of test scenarios  
  
Workflow configuration can be found here:  

.github/workflows

  
This ensures that automated tests run consistently in a CI pipeline similar to real-world QA environments.  
  
---  
## Reporting

The framework generates a detailed HTML report for every execution.
 

-  **Local:**  `target/cucumber-reports.html`

-  **GitHub Actions:** Download the `cucumber-report` artifact from the **Summary** page of any successful run.

-  **Features:** Includes step-by-step pass/fail status, execution time, and Gherkin formatting.
 ---
## Test Execution Screenshot

Console Output using Maven execution

![Maven Result](https://github.com/gian-aguilar/DemoWebShop-Selenium-Java-BDD/blob/main/screenshots/test-execution.png?raw=true)


Cucumber Report

![Cucumber Report](https://github.com/gian-aguilar/DemoWebShop-Selenium-Java-BDD/blob/main/screenshots/cucumber-report.png?raw=true)
  
## Purpose of This Project  
  
This project serves as a portfolio automation framework demonstrating:  
  
- Selenium automation framework development  
- Behavior Driven Development (BDD) implementation  
- Page Object Model architecture  
- CI/CD pipeline integration  
  
---  
  
## Author  
  
Gian Aguilar   
Senior QA Engineer | Automation Enthusiast
