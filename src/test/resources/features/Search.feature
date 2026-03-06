Feature: Search product

@Search
Scenario Outline: Search and view product details
    Given I am on the demo shop home page
    When I search for "<productname>"
    And I click on the product "<productname>"
    Then the page title should contain "<productname>"
    
Examples:
|productname|
|Blue Jeans|