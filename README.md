# show-booking-app
 show-booking-app<br>
 Built Jar is in the output folder.<br>
 Use the folowing command to run the Jar.<br>
 **java -cp jpmc-1.0-SNAPSHOT.jar jpmc.book.Application**
<br><br>
**Please follow below instructions:**<br>
<br>
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
