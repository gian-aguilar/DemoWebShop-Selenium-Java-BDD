Feature: Demo Web Shop Login

  @Login
  Scenario Outline: Successful Login into Demo Web Shop
    Given I am on the demo web shop login page
    When I enter "<username>" and "<password>"
    And I click the login button
    Then the logout link should display

    Examples:
      | username                    | password     |
      | testemail2026@testemail.com | testpass2026 |

  @Invalid_Login
  Scenario Outline: Login into Demo Web Shop using invalid password
    Given I am on the demo web shop login page
    When I enter "<username>" and "<password>"
    And I click the login button
    Then the unsuccessful message "Login was unsuccessful. Please correct the errors and try again." should display

    Examples:
      | username                    | password |
      | testemail2026@testemail.com | testpass |
