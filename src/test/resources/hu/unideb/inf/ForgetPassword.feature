Feature:  search feature functionality test

  Background:
    Given the home page is opened
    And the Sign In link is clicked for password test
    And the forget your password button is clicked


  Scenario Outline:
    Given the '<field>' is filled with '<parameter>' in email
    When the Retrieve Password button is clicked
    Then the '<msg>' error message is shown above
    Examples:
      | field     | parameter         | msg                        |
      | email     |                   | Invalid email address.     |
      | email     | invalid.email.com | Invalid email address.     |
      | email     | 666@qq.com        | There is no account registered for this email address.|


  Scenario: Empty email with Enter key
    Given the "email" is filled with "" in email
    When the Retrieve Password button is clicked
    Then the "Invalid email address." error message is shown above

  Scenario: wrong search test with Enter key
    Given the "email" is filled with "invalid.email.com" in email
    When the Retrieve Password button is clicked
    Then the "Invalid email address." error message is shown above

  Scenario: used email search
    Given the "email" is filled with "666@qq.com" in email
    When the Retrieve Password button is clicked
    Then the "There is no account registered for this email address." error message is shown above

  Scenario: right email search
    Given the "email" is filled with "2742674482@qq.com" in email
    When the Retrieve Password button is clicked
    Then the "A confirmation email has been sent to your address: 2742674482@qq.com"  message is shown

