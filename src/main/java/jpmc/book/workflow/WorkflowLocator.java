package jpmc.book.workflow;

import jpmc.book.interpreter.command.enums.CommandType;
import jpmc.book.workflow.booking.BookingShowWorkflow;
import jpmc.book.workflow.booking.CancelBookingWorkflow;
import jpmc.book.workflow.login.LoginWorkflow;
import jpmc.book.workflow.login.LogoffWorkflow;
import jpmc.book.workflow.show.AvailabilityWorkflow;
import jpmc.book.workflow.show.SetUpShowWorkflow;
import jpmc.book.workflow.show.ViewShowWorkflow;
import jpmc.book.workflow.user.AddUserWorkflow;

import java.util.HashMap;
import java.util.Map;

public class WorkflowLocator {

    private static Map<CommandType, Workflow>  workflowMap = new HashMap<>();

    static {
        workflowMap.put(CommandType.ADD_USER, new AddUserWorkflow());
        workflowMap.put(CommandType.SETUP_SHOW, new SetUpShowWorkflow());
        workflowMap.put(CommandType.VIEW_SHOW, new ViewShowWorkflow());
        workflowMap.put(CommandType.LOGIN, new LoginWorkflow());
        workflowMap.put(CommandType.LOGOFF, new LogoffWorkflow());
        workflowMap.put(CommandType.BOOK, new BookingShowWorkflow());
        workflowMap.put(CommandType.AVAILABILITY, new AvailabilityWorkflow());
        workflowMap.put(CommandType.CANCEL, new CancelBookingWorkflow());
    }

    public static Workflow getWorkflow(CommandType commandType) {
        return workflowMap.get(commandType);
    }

}
