# show-booking-app
 Compiled Jar **jpmc-1.0-SNAPSHOT.jar** can be found in the output folder.<br><br>
 Use the folowing command to run the Jar :-<br>
 _java -cp jpmc-1.0-SNAPSHOT.jar jpmc.book.Application_
<br><br>
**Please follow below instructions:**<br>
Add a new user and Login before calling Admin or Buyer Commands.
<br><br>
**AddUser** username admin|buyer<br>
**Login** username<br>
**Logoff**<br>
 <br>
**ADMIN Commands**<br>
**Setup** Show_Number Number_of_Rows Number_of_seats_per_row Cancellation_window_in_minutes<br>
**View** Show_Number<br>
<br>
**BUYER Commands**<br>
**Availability** Show_Number<br>
**Book** Show_Number Phone# Comma_separated_list_of_seats<br>
**Cancel** Ticket# Phone#<br>
