package jpmc.book.reader;

import jpmc.book.display.Display;
import jpmc.book.exception.BookAShowException;
import jpmc.book.interpreter.command.Command;
import jpmc.book.interpreter.parser.CommandParser;

import java.util.Scanner;

public class InputReader {

    private static final String EXIT_COMMAND = "EXIT";

    public void read() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while(!EXIT_COMMAND.equalsIgnoreCase(input)) {
            try {
                input = scanner.nextLine();
                Command command = CommandParser.parseCommand(input);
                if (command != null) {
                    command.execute();
                } else if(!EXIT_COMMAND.equalsIgnoreCase(input)) {
                    Display.message("Invalid Command. Type Help for Full Command List.");
                }
            } catch (BookAShowException ex) {
                Display.exception(ex);
            }
        }
    }

}
