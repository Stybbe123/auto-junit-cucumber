@web
@all
Feature: Google page test UI using image comparison

  I navigate to "https://www.google.com/"
  I verify that main image matches "test.jpg" image

  Scenario: Check google logo
    Given page open link "https://google.com"
    When capture logo
    Then compare with saved screenshot by screenshotName "logo.png" and matchScore is greater then 80 percent