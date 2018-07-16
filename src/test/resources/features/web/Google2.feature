@web
@all
Feature: Google page test UI using image comparison, 2nd run

  I navigate to "https://www.google.com/" again
  I verify that main image matches "some.jpg" image

  Scenario: Check google logo 2nd time
    Given page 2 open link "https://google.com"
    When capture 2 logo
    Then compare 2 with saved screenshot by screenshotName "logo.png" and matchScore is greater then 80 percent