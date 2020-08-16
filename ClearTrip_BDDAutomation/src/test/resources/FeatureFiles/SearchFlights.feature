@Book_Flight_Tikect
Feature: Sanity Testing.
  In order to book the tickets verify that ClearTrip page is loading and able to book the tickets
  
@ClearTrip
Scenario Outline: Validate Flight ticket booking
	Given I am on the Home Page "https://www.cleartrip.com" of cleartrip Website
    Then I select RoundTrip radioButton
    Then I enter <From> and <To> values 
    Then I enter <Departure> and <ReturnDate>
    Then I select <adults> and <childs>
    Then I click on Search Flights
    Then I select <depart> Flight and <return> flight to book tickets
    Then I read departure Flights <specific> rowData
    Then I read Return Flights <specific> rowData
    Then I Book the Tickets
    
    
    Examples:  
    |  From    			|  To   			 |Departure 	|ReturnDate  |adults|childs|specific|depart|return|
    | "Hyderabad"     	| "Bangalore"        |"25/08/2020"  |"30/08/2020"|"4"   |"2"   |1       |1     |1     |
   
    