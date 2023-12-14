Feature:Login

 @Smoke
 Scenario:Login with valid credentials
   Given user lunch the browser
   And user open the application url"https://www.screwfix.com/"
   And user navigate to your account menu
   And user click on login button
   Then user navigate to your account page by passing Email and Password with excel row "<row_index>"
   
   Examples:
   |row_index|
   |1|
   |2|
   |3|
   |4|
   
  


















