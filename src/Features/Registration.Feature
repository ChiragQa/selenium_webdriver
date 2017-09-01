Feature: Bidder registration

Background:
		Given User Open Browser
    And Navigate to URL Domain
    
  @tag1
  Scenario Outline: Bidder Register with Already Registered Email Id
  	
  	Given User click on Bidder registration Page
     And User is on Registration Page.
    When bidder Enter Email Id As "<EmailId>"
    Then System Validate with Message As "<Validation>"

    Examples: 
      | EmailId                    | Validation                                           |
      | nipun.abcprocure@gmail.com | Email id already registered as bidder on this domain |

  Scenario Outline: Bidder Register with Invalid Email Id
   
    Given User click on Bidder registration Page
     And User is on Registration Page.
    When bidder Enter Email Id As "<EmailId>"
    Then System Validate with Error Message As "<Validation>"

    Examples: 
      | EmailId                    | Validation                                                         |
      | nipun.abcprocure@gmail     | Please enter valid email ID                                        |
      | nipun.abcprocure!gmail.com | Allows Min. 6 Max. 50 alphanumeric and Special Characters(@,.,-,_) |
  @smoke
 Scenario: Bidder Register with Valid Email Id
    
    Given User click on Bidder registration Page
     And User is on Registration Page.
    When bidder Register with Valid Detail
    Then Registration Complete with successful message
    
Scenario: Bidder Register with Valid Email Id
    
    Given User click on Login Page
    When bidder Login with Username and Password.
    Then Loginsuccessful and Redirecting to Homepage.    
