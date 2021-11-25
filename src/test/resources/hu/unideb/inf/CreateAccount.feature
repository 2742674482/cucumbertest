Feature: YourLogo sign in page test

  Background:
    Given the home page is opened
    And the Sign In link is clicked in CreatAccount

  Scenario Outline:
    Given the '<field>' is filled with '<parameter>' in email address
    When the Create an account button is clicked
    Then the '<msg>' error message is shown out
    Examples:
      | field        | parameter         | msg                        |
      | email_create |                   | Invalid email address      |
      | email_create | invalid.email.com | Invalid email address.     |
      | email_create | 2742674482@qq.com | An account using this email address has already been registered. Please enter a valid password or request a new one.|

  Scenario: Empty email
    Given the "email_create" is filled with "" in email address
    When the Create an account button is clicked
    Then the 'Invalid email address' error message is shown out


  Scenario: Wrong email
    Given the "email_create" is filled with "invalid.email.com" in email address
    When the Create an account button is clicked
    Then the 'Invalid email address' error message is shown out


  Scenario: uesd email
    Given the "email_create" is filled with "2742674482@qq.com" in email address
    When the Create an account button is clicked
    Then the 'An account using this email address has already been registered. Please enter a valid password or request a new one.' error message is shown out





