package jpmc.book.interpreter.command;

import jpmc.book.exception.BookAShowException;
import jpmc.book.interpreter.command.enums.CommandType;
import jpmc.book.workflow.WorkflowLocator;

public class LogoffCommand extends BaseCommand {

    @Override
    public void execute() throws BookAShowException {
        WorkflowLocator.getWorkflow(CommandType.LOGOFF).execute(null);
    }
}
