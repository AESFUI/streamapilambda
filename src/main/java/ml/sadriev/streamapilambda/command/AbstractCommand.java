package ml.sadriev.streamapilambda.command;

/**
 * @author Andrey Sadriev
 */
public abstract class AbstractCommand {

    public abstract void execute() throws Exception;

    public abstract String command();

    public abstract String description();

}
