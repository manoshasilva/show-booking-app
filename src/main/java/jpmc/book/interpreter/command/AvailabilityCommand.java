package jpmc.book.interpreter.command;

import jpmc.book.context.Context;
import jpmc.book.display.Display;
import jpmc.book.exception.BookAShowException;
import jpmc.book.interpreter.command.enums.CommandType;
import jpmc.book.model.Show;
import jpmc.book.workflow.WorkflowLocator;

public class AvailabilityCommand extends BaseCommand {

    @Override
    public void execute() throws BookAShowException {
        if(params != null && params.length == 1) {
            Context context = new Context().show(new Show().showNumber(params[0]));
            WorkflowLocator.getWorkflow(CommandType.AVAILABILITY).execute(context);
        } else {
            Display.message("Command is invalid. Please use following syntax.");
            Display.message("Availability <Show Number>");
        }
    }

}
