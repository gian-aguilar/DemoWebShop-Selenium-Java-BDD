Feature: Shopping Cart Management

  @AddToCart
  Scenario Outline: User can add an item to the basket
    Given I am on the product viewing page
    And the shopping cart quantity should be "1" by default
    When I click the Add to cart button for "<productname>"
    Then a success message contains "The product has been added to your " should appear

    Examples:
      | productname |
      | Blue Jeans  |

  @Checkout
  Scenario Outline: User proceed to check out
    Given I am logged in with valid credentials
    When I search for "<productname>"
    And I click on the product "<productname>"
    When I click the Add to cart button for "<productname>"
    And I go to shopping cart
    When I proceed to check process
    Then a confirmation message contains "Your order has been successfully processed!" should display

    Examples:
      | productname |
      | Blue Jeans  |
