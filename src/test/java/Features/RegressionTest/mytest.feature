
Feature: Sauce Lab Login test
Feature Description: Test login feature


@regression
Scenario Outline: Login test - positive scenario
    
        Given I navigate to sauce lab "<url>"
        When I enter username "<username>"
            And I enter password "<password>"
            And I click login button
        Then I validate user login is successful "<successfulMsg>"
        
    Examples:
        | url                                           |    username                   |   password     |  successfulMsg   |
        | https://accounts.saucelabs.com/am/XUI/#login/ |    mahiuddins27@gmail.com     |   Testing@12   |  Log out         |


# @em
# Scenario Outline: Complete first page as an existing member
    
#         Given I navigate to oao
#             When I enter "<firstName>","<lastName>","<dob>","<ssn>" as eligibility information
#             And I click on member security check toggle
#             And I enter "<memberNumber>" and "<accountNumber>"
#             And I enter "<email>","<mobileNumber>","<homeNumber>" as contact information
#             And I enter "<street>","<city>","<state>","<zip>" as home address
#             And I enter "<street>","<city>","<state>","<zip>" as mailing address
#             And I enter "<street>","<city>","<state>","<zip>" as work address
#         When I click continue button
#         Then I land on fourth page "<FourthPage>"
        
#     Examples:
#         | FourthPage                               |
#         | Choose Your Products and Services        |     


   