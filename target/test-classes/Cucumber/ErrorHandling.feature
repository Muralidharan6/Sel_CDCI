@tag
Feature: Error hading from Ecommerce website
	I want to use this template for my feature file

  @Error_Handle
  Scenario Outline: Negative test
    Given landed on Ecommerce page
    When logged in with username "<user>" and password "<pwd>"
    Then "Incorrect email or password." message displayed on Login page

    Examples:
      | user                  | pwd        |
      | testuser126@gmail.com | Kannan@123 |