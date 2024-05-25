Feature: Google

#  Background:
#    Given Will go to google home page

  @Smoke @New
  Scenario Outline: Googl: Happy Path
    When Will go to google home page
    And Enter text youtube
    Then Click on the search button
    Examples:
      |  jfhdhg |