Feature:Login page Automation of saucedemo

Scenario:Check login is scuccessful for valid info

Given User is login page
When User enters username as "standard_user" 
And User enters password as "secret_sauce"
And Click on login button
Then user navigate to login home page

Scenario:Check the Logout is scuccessful

Given User should navigate to inventory page
And User should select the dropdown list
When User click the Logout 
Then User navigate to login page

Scenario:Check Login is failed
Given User is login page
When User enters username as "standard_user" 
And User enters password as "secret"
And Click on login button
Then user get error message 







