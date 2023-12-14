Feature:Login

 @Sanity
 Scenario:Login with valid credentials
   Given user lunch the browser
   And user open the application url"https://www.screwfix.com/"
   And user navigate to your account menu
   When user entered Email as "olakayjulius@yahoo.com" and Password as "Wayoman$"
   And user click on login button
   Then user navigate to successful signed in page
  


















