Feature: Automation Sauce Demo

  Scenario Outline: Add Cart to Demo
    Given User enter into login page
    And User enter login as "<username>" and "<password>"
    And User search item "<item>"
    And User add the item into cart
    Then Cart should be updated

    Examples:
		|username|password|item|
		|standard_user|secret_sauce|Sauce Labs Backpack|
		