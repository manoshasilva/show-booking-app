package jpmc.book.interpreter.command;

import jpmc.book.context.Context;
import jpmc.book.display.Display;
import jpmc.book.exception.BookAShowException;
import jpmc.book.interpreter.command.enums.CommandType;
import jpmc.book.model.Show;
import jpmc.book.workflow.WorkflowLocator;

public class ViewShowCommand extends BaseCommand {

    @Override
    public void execute() throws BookAShowException {
        if(params != null && params.length == 1) {
            Show show = new Show().showNumber(params[0]);
            Context context = new Context().show(show);
            WorkflowLocator.getWorkflow(CommandType.VIEW_SHOW).execute(context);
        } else {
            Display.message("Command is invalid. Please use following syntax.");
            Display.message("View <Show Number>");
        }
    }
}
