package jpmc.book.interpreter.command;

import jpmc.book.context.Context;
import jpmc.book.display.Display;
import jpmc.book.exception.BookAShowException;
import jpmc.book.interpreter.command.enums.CommandType;
import jpmc.book.model.Booking;
import jpmc.book.workflow.WorkflowLocator;

public class CancelBookingCommand extends BaseCommand {

    @Override
    public void execute() throws BookAShowException {
        if(params != null && params.length == 2) {
            Booking booking = new Booking().ticketId(params[0]).phoneNumber(params[1]);
            Context context = new Context().booking(booking);
            WorkflowLocator.getWorkflow(CommandType.CANCEL).execute(context);
        } else {
            Display.message("Command is invalid. Please use following syntax.");
            Display.message("Cancel <Ticket#> <Phone#>");
        }
    }

}
