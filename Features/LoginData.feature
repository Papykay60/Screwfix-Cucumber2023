Feature: Datadriven

 @Regression 
  Scenario Outline: Data driven test
    Given user lunch the browser
    And user open the application url"https://www.screwfix.com/"
    And user navigate to your account menu
    When user entered Email as "<email>" and Password as "<password>"
    And user click on login button
    Then user navigate to successful signed in page
  
    Examples: 
      | email                    | password       |
      | olakayjulius@yahoo.com   | Wayoman$       |
      | Kay@yahoo.com	           | Wayocity       |
      | olakayjuli@yahoo.com	   | Wayoman$	      |
      | olayjulius@yahoo.com	   | Wayomanton     |
      | Juliusoladele60@gmail.com|	Olowolayemo12!|
                           