package jpmc.book.interpreter.command.enums;

import jpmc.book.interpreter.command.*;

import java.util.HashMap;
import java.util.Map;

public enum CommandType {

    ADD_USER("AddUser", new AddUserCommand()),
    SETUP_SHOW("Setup", new SetUpShowCommand()),
    VIEW_SHOW("View", new ViewShowCommand()),
    LOGIN("Login", new LoginCommand()),
    LOGOFF("Logoff", new LogoffCommand()),
    BOOK("Book", new BookingShowCommand()),
    AVAILABILITY("Availability", new AvailabilityCommand()),
    CANCEL("Cancel", new CancelBookingCommand()),
    HELP("Help", new HelpCommand());

    private static final Map<String, Command> BY_VALUE = new HashMap<>();

    static {
        for(CommandType commandType : values()) {
            BY_VALUE.put(commandType.value, commandType.command);
        }
    }

    private String value;
    private Command command;

    CommandType(String value, Command command) {
        this.value = value;
        this.command = command;
    }

    public static Command getCommandsByValue(String command) {
        return BY_VALUE.get(command);
    }

}
