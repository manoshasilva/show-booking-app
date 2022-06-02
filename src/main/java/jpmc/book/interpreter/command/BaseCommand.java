package jpmc.book.interpreter.command;

public abstract class BaseCommand implements Command {

    protected String[] params;

    @Override
    public void setParams(String[] params) {
        this.params = params;
    }
}
