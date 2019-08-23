Feature: Validating  TestMeApp

  @Smoke
  Scenario Outline: Registration of TestMeApp
    Given App is launched
    When User clicks on SignUp
    Then User provides the fields "<uname>" "<fname>" "<lname>" "<pass>" "<cpass>" "<mail>" "<numb>" "<dob>" "<add>"
    And clicks on Register button

    Examples: 
      | uname     | fname | lname  | pass    | cpass   | mail           | numb       | dob        | add              |
      | Christ900 | Tom   | Cruise | Tom123  | Tom123  | tom@gmail.com  | 1234567890 | 12-12-2012 | 1-10-12 MG ROAD  |
      | Christ901 | Dome  | Druise | Dome123 | Dome123 | dome@gmail.com | 0987654321 | 11-11-2011 | 34-56 GACHIBOWLI |
      | Christ902 | Dale  | Steyn  | Dale123 | Dale123 | dale@gmail.com | 5432167890 | 10-10-2010 | 67-43 JAPAN      |

  @Sanity
  Scenario Outline: Login with different users
    Then Enter valid username "<uname>"
    And Enter valid password "<pass>"
    And click on Login

    Examples: 
      | uname   | pass        |
      | Lalitha | Password123 |

  @Sanity
  Scenario: Purchase a product
    When User click on the search tab
    Then User enters the product name
    And User selects the product from the dropdown
    Then User adds the product in the cart
    And User does the payment

  @Sanity
  Scenario: User moves to cart without adding anything to it
    Given Launch the application
    When User clicks on Login
    Then User enters the credentials
    And clicks on Login
    Then Search a particular product
    And Proceed to payment without adding any item to the cart
    Then App doesnt display the cart icon
 
 
 
 
 
 
 
 
 
 
