Feature: Login

Background:
  Given user navigates to login Page

  Scenario Outline: successful user login with valid credentials
    Given user enters valid username "<user_name>" and password "<password>"
    When user clicks on login button
    Then user navigates to page with title "<Title>"
    Examples:
      | user_name     | password     | Title     |
      | standard_user | secret_sauce | Swag Labs | 