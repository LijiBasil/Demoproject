Feature: Check functionalities of OrangeHRM website

  As a user of OrangeHRM site
  I wanted to be logged in with provided credentials
  I want to update the DOB in MyInfo page
  I want to logout successfully

  Background:
    Given I am on OrangeHRM webpage

    Scenario:Login successfully with provided credentials
      Given I have entered the valid username and password
      And I click on login button
      Then I have successfully landed the dashboard page

    Scenario: User should be able to navigate to MyInfo page and Update DOB field
      Given I am on the admin panel
      And I click on My Info at the sidebar menu
      Then My Info page should be loaded successfully
      And I verify if the DOB field is prefilled
      And I update the DOB field to new value
      And I click on save button
      Then My Info page should be updated with updated DOB

   Scenario: Verify logout functionaity
     Given I am on the admin panel
     And I click on logout button
     Then I should be navigated back to login page
