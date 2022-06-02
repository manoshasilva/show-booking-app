package jpmc.book.interpreter.command;

import jpmc.book.context.Context;
import jpmc.book.display.Display;
import jpmc.book.exception.BookAShowException;
import jpmc.book.interpreter.command.enums.CommandType;
import jpmc.book.model.User;
import jpmc.book.workflow.WorkflowLocator;

public class LoginCommand extends BaseCommand {

    @Override
    public void execute() throws BookAShowException {
        if(params != null && params.length == 1) {
            User user = new User().userName(params[0]);
            Context context = new Context().user(user);
            WorkflowLocator.getWorkflow(CommandType.LOGIN).execute(context);
        } else {
            Display.message("Command is invalid. Please use following syntax.");
            Display.message("Login <username>");
        }
    }
}
