Feature: Registration page



#Scenario: Verify error message when user enters invalid mobile number
#	When user fills the entire form with invalid mobile number
#	And click on register button
#	Then User should get error message

#Scenario: Step parameterization
#	Given I have two number 12.45 and 47
#	When I add them
#	Then print the result
	
#Scenario: Step parameterization with string and word
#	Given I have a string "Hello"
#	Given I have a word "Hi"
	
#Scenario: Passing list to step definition
#	Given I have following items:
#	|"Orange"|1|
#	|"Pineapple"|2|
#	|"Apple"|5|
#	|"Peach"|1|

Scenario Outline: This is my first data driven test case
	Given I have <quantity> <fruit>
	
Examples:
	|fruit|quantity|
	|"Orange"|1|
	|"Pineapple"|2|
	|"Apple"|5|
	|"Peach"|1|
	
	
	
	
	
	
	
	
	
	
	