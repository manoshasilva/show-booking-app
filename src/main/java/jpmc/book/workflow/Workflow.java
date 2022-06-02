package jpmc.book.workflow;

import jpmc.book.context.Context;
import jpmc.book.exception.BookAShowException;

public interface Workflow {

    void execute(Context context) throws BookAShowException;

}
