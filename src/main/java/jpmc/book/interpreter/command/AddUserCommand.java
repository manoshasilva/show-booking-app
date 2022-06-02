package jpmc.book.interpreter.command;

import jpmc.book.context.Context;
import jpmc.book.display.Display;
import jpmc.book.exception.BookAShowException;
import jpmc.book.interpreter.command.enums.CommandType;
import jpmc.book.model.User;
import jpmc.book.model.UserType;
import jpmc.book.workflow.WorkflowLocator;

public class AddUserCommand extends BaseCommand {

    @Override
    public void execute() throws BookAShowException {
        if(params != null && params.length == 2) {
            User user = new User().userName(params[0]).userType(UserType.getUserTypeByValue(params[1]));
            Context context = new Context().user(user);
            WorkflowLocator.getWorkflow(CommandType.ADD_USER).execute(context);
        } else {
            Display.message("Command is invalid. Please use following syntax.");
            Display.message("AddUser <username> <admin|buyer>");
        }
    }
}
