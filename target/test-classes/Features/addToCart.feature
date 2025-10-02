Feature: Automation Sauce Demo

  Scenario Outline: Add Cart to Demo
    Given User is login page
    And User enter login as "<username>" and "<password>"
    And User search item "<item>"
    And User add the item into cart
    Then Cart should be updated

    Examples:
		|username|password|item|
		