Feature: SauceDemo Automation Testing

  Scenario: Display the List of Items from Inventory Page
    Given User is on the Login Page
    When User enters valid username as "standard_user"
    And User enters valid password as "secret_sauce"
    And User clicks the login button
    Then User should be navigated to the Inventory Page
    And User should see a list of all available inventory items
