Feature: Customers
Background: Steps common for all scenarios
Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashborad

@Sanity
Scenario: Add new customer
    
    When User click on customer Menu
    And click on customers Menu Item
    And click in Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on save button
    Then User can view confirmarion message "The new customer has been added successfully."
    And close browser
  
    @regression  
    Scenario: Search customer by Email
    When User click on customer Menu
    And click on customer Menu Item
    And Enter cuctomer Email
    When Click on search button
    Then User should found Email in the Search table
    And close browser
    
    @regression
    Scenario: Search customer by Name
    When User click on customer Menu
    And click on customer Menu Item
    And Enter cuctomer FirstName
    And Enter cuctomer LastName
    When Click on search button
    Then User should found Name in the Search table
    And close browser
    
    
    