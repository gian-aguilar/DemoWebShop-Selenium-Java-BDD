Feature: Happy Path

@HappyPath
  Scenario Outline: Valid user buys Blue Jeans and Logs out
    Given I am on the demo web shop login page
    When I enter "<username>" and "<password>"
    And I click the login button
    Then the logout link should display
    When I search for "<productname>"
    And I click on the product "<productname>"
    When I click the Add to cart button for "<productname>"
    And I go to shopping cart
    When I proceed to check process
    Then a confirmation message contains "Your order has been successfully processed!" should display
    When I Log out to demo web shop
    Then verify if the Login is visible

    Examples:
      | username                    | password     | productname |
      | testemail2026@testemail.com | testpass2026 | Blue Jeans  |
