package jpmc.book.interpreter.parser;

import jpmc.book.interpreter.command.Command;
import jpmc.book.interpreter.command.enums.CommandType;

import java.util.Arrays;

public class CommandParser {

    public static Command parseCommand(String strCommand) {
        String[] commands = strCommand.split(" ");
        Command command = CommandType.getCommandsByValue(commands[0]);
        if(command != null) {
            command.setParams(Arrays.copyOfRange(commands, 1, commands.length));
        }
        return command;
    }

}
