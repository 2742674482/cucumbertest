Feature: NewsLetter subscribed
  Background:
    Given the home page is opened

    Scenario Outline:
      Given the '<field>' is filled with '<parameter>' in newsletter
      When submitNewsletter button clicked
      Then the '<msg3>' error message comes
      Examples:
      |field           |parameter           |msg3                                                               |
      |newsletter-input|                    | Newsletter : Invalid email address.                               |
      |newsletter-input|abcd.com            | Newsletter : Invalid email address.                               |
      |newsletter-input|abcdef@email.com    | Newsletter : This email address is already registered.            |
