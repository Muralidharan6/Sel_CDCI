@tag
Feature: purchase the order from Ecommerce website
	I want to use this template for my feature file

  Background:
    Given landed on Ecommerce page

  @Regression
  Scenario Outline: Positive test for submitting order
    Given logged in with username "<user>" and password "<pwd>"
    When add product "<prodName>" to cart
    And checkout "<prodName>" and submit to order
    Then "THANKYOU FOR THE ORDER." message displayed on confirmation page

    Examples:
      | user                   | pwd        | prodName        |
      | testuser1269@gmail.com | Kannan@123 | ZARA COAT 3     |
      | google@test.com        | Admin123   | ADIDAS ORIGINAL |
