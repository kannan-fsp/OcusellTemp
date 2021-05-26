@Reggression
Feature: Running ocusell dev server script

@Landingpage
Scenario: Verify landing page
Given Launch browser and load dev server URL
When Verify links are working
Then Verify yearly price

@Login
Scenario: Verify login page
Given Launch login page
When Verify failure message with incorrect details
And Verify login page with correct details
Then Verify success message

@Dashboard
Scenario: Verify Dashboard page
Given Verify page title 
When check active counts
Then total counts and confirm the user account

@MyCollaborate
Scenario: Verify MyCollaborate page
Given Verify search is working good
When Verify View and Collaborate link is there
Then Verify search filter counts are showing correctly

@ViewCollaborate
Scenario: Verify view collaborate page
Given Goto view collaborate screen
When Verify firstname and lastname of the user
And Verify listing assigned for that user
Then Close the window

@EditCollaborate
Scenario: Verify edit collaborate page
Given Goto view collaborate page
When Edit contact and update
And Verify details are updated on the my collaborate page

@CollaboratePopup
Scenario: Verify collaborate page
Given Search any user then click collaborate link
When Verify firstname and lastname on the popup
Then Assign listing if there
And Verify assigned listing is displayed on My collaborators page

#send new invite comes here

@Settings
Scenario: Verify settings page
Given Goto settings page and verify title 
When verify list of options
Then Verify all links are working

@AccountSettings
Scenario: Verify account settings page
Given Update field
When Click update button
Then Verify field is updated with recent data

@ChangePhoto
Scenario: Verify change photo function
Given Open Account settings screen
When Click change photo button
Then Upload photo

@ChangePassword
Scenario: Verify change password function
Given Goto Account settings page and open check password popup
When Enter the password field
Then Verify password updated are working correctly

@NotificationBellSettings
Scenario: Verify notification bell settings
Given Click notification bell
When Verify notification count on the dropdown
Then Click notification settings icon on the right side of the dropdown
And Verify enable disable notification

@PaymentSettings
Scenario: Verify payment settings page
Given Goto payment settings page
When Verify current plan and verify cancel plan
Then Verify change card

@Marketplace
Scenario: Verify sidebar marketplace is looking good
Given Goto marketplace page
When Verify search
Then Verify mark as completed checkbox

@AllNotifications
Scenario: Verify all notifications
Given Goto notification bell settings 
When Click All notification from dropdown
Then Verify older and latest notifications
And Click logout

@Registration
Scenario: Verify registration is good
Given Goto firststep and fill everything
When Choose pricing
Then Enter card info then submit
