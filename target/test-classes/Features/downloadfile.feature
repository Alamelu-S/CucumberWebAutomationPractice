Feature: File Download Automation

Scenario: Download a sample file
  Given User is on download page
  When User clicks the download link
  Then File should be downloaded successfully
