Feature: Login Functionality Testing

Scenario: Successful Login 

Given user is login page
When user enter username as "admin"
And  user enter password as "admin123"
And user enter age as 28
And  user click login button
Then user should be navigated to next page

Scenario Outline:

Given user is login page
When user enter username as "<username>" 
And user enter password as "<password>"
And user click login button
Then user navigate to next page

Examples:
| username | password |
| admin    | admin123 |


