Feature: Cart test

  Background:
    Given the home page is opened

  Scenario:
    Given the Cart button is clicked
    Then the "Your shopping cart is empty." error message is shown in cart



