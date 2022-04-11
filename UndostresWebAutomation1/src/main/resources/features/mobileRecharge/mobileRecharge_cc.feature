Feature: Mobile recharge Automation on UNDOSTRES web Application 
	Description: This is a demo test, to do a mobile recharge

@QA_TEST
Scenario Outline:
Verify a user should able to do mobile recharge by a given credit card 
	Given The test execution is running on "<Environment>"
	Then Verify undostres logo is displayed on home screen
	Then Verify "Recarga Celular" text label displayed on container
	And User select the "Operator" as "<Operator>" from dropdown options
	And User enter the "Numero de celular" as "<cellPhoneNum>" from text field
	When User click on "Monto de Recarga" field on displayed mobile recharge container
	Then Verify suggestion modal is displayed
	And User click on "Recarga Saldo" tab on suggestion modal
	And User select $"<Amount>" on suggestion modal
	When User click on "Siguiente" button on displayed mobile recharge container
	Then Verfy user should be moved on "/payment.php" page
	And User click on "Tarjeta" payment and choose "Usar nueva tarjeta"
	And User enter "<cardNumber>" in "Numero de celular" text field at card panel
	And User enter "<month>" in "Mes" text field at card panel
	And User enter "<date>" in "Año" text field at card panel
	And User enter "<cvv>" in "CVV" text field at card panel
	And User enter "<email>" in "correo electronico" text field at card panel
	And Verify "Pagar con Tarjeta" button is enabled
	When User click on "Pagar con Tarjeta" button
	Then "Registration/Login" modal should get displayed
	And Enter "<username>" and "<password>" on displayed panel
	And user click on captcha checkbox
	And Verify "Acceso" button is enabled
	And User click on "Acceso" button
	And Verify "¡Recarga Exitosa!" message is dispalyed
	And User click on Logout
	
	# here you can pass any set of data and any number of data as given below
	Examples: 
		| Environment | Amount | cellPhoneNum | cardNumber      | Operator | month | date | cvv | email 		 | username 				| password 		   |
		| QA		  | 10	   | 8465433546   | 4111111111111111| Telcel   | 11    | 25   | 111 | test@test.com  | automationUDT1@gmail.com | automationUDT123 |
