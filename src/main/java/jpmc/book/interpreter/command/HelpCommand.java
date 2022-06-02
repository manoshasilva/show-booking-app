package jpmc.book.interpreter.command;

import jpmc.book.display.Display;

public class HelpCommand extends BaseCommand {

    @Override
    public void execute() {
        Display.help();
    }

}
