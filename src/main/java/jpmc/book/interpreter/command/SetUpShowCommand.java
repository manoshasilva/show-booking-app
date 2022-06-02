package jpmc.book.interpreter.command;

import jpmc.book.context.Context;
import jpmc.book.display.Display;
import jpmc.book.exception.BookAShowException;
import jpmc.book.interpreter.command.enums.CommandType;
import jpmc.book.model.Show;
import jpmc.book.workflow.WorkflowLocator;

public class SetUpShowCommand extends BaseCommand {

    @Override
    public void execute() throws BookAShowException {
        if (params != null && params.length == 4) {
            Show show = new Show().showNumber(params[0]).noOfRows(Integer.parseInt(params[1]))
                    .noOfSeatsPerRow(Integer.parseInt(params[2]))
                    .cancellationWindowInMinutes(Integer.parseInt(params[3]));
            Context context = new Context().show(show);
            WorkflowLocator.getWorkflow(CommandType.SETUP_SHOW).execute(context);
        } else {
            Display.message("Command is invalid. Please use following syntax.");
            Display.message("Setup <Show Number> <Number of Rows> <Number of seats per row> <Cancellation window in minutes>");
        }
    }
}
