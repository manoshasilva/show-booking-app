package jpmc.book.interpreter.command;

import jpmc.book.exception.BookAShowException;

public interface Command {

    void execute() throws BookAShowException;

    void setParams(String[] params);

}
