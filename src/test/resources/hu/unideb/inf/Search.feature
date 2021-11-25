Feature:  search feature functionality test

  Background:

    Given the home page is opened

  Scenario Outline: Invalid search test with Enter key
    Given the '<searchField>' is filled with '<parameter>' in search field
    When the search button is clicked
    Then the '<msg>' error message is shown in search
    Examples:
      | searchField             | parameter         | msg                                                       |
      | search_query_top        |                   | Please enter a search keyword                             |
      | search_query_top        | abcd              | No results were found for your search "abcd"              |

    Scenario: Empty search test with Enter key
      Given the "search_query_top" is filled with "" in search field
      When the Enter button is pressed
      Then the "Please enter a search keyword" error message is shown in search

    Scenario: wrong search test with Enter key
      Given the "search_query_top" is filled with "Gundam" in search field
      When the Enter button is pressed
      Then the "No results were found for your search Gundam" error message is shown in search

    Scenario: Multiple search
      Given the "search_query_top" is filled with "Dress" in search field
      When the search button is clicked
      Then the related item "Dress" is listed in search

    Scenario: Unique  search
      Given the "search_query_top" is filled with "Blouse" in search field
      When the search button is clicked
      Then the related unique item "Blouse" is listed in search

