Feature: File Upload Automation

Scenario: Upload a sample file
  Given User is on file upload page
  When User selects the file "C:\Users\alame\OneDrive\Desktop\Sample File to upload.txt"
  And Clicks on Upload button
  Then File should be uploaded successfully
