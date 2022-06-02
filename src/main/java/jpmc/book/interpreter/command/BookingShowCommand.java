package jpmc.book.interpreter.command;

import jpmc.book.context.Context;
import jpmc.book.display.Display;
import jpmc.book.exception.BookAShowException;
import jpmc.book.interpreter.command.enums.CommandType;
import jpmc.book.model.Booking;
import jpmc.book.model.Show;
import jpmc.book.workflow.WorkflowLocator;

public class BookingShowCommand extends BaseCommand {

    @Override
    public void execute() throws BookAShowException {
        if(params != null && params.length == 3) {
            Show show = new Show().showNumber(params[0]);
            Booking booking = new Booking().showNumber(params[0]).phoneNumber(params[1]);
            booking.addSeats(params[2].split(","));
            Context context = new Context().show(show).booking(booking);
            WorkflowLocator.getWorkflow(CommandType.BOOK).execute(context);
        } else {
            Display.message("Command is invalid. Please use following syntax.");
            Display.message("Book <Show Number> <Phone#> <Comma separated list of seats>");
        }
    }
}
