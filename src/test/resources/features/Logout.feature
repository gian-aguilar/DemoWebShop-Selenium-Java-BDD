Feature: Demo Webshop Log out

@Logout
Scenario: User Logs out to demo web shop

Given I am logged in with valid credentials
When I Log out to demo web shop
Then verify if the Login is visible


