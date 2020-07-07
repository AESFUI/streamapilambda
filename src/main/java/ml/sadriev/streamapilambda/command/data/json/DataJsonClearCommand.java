package ml.sadriev.streamapilambda.command.data.json;

import org.springframework.stereotype.Component;
import ml.sadriev.streamapilambda.command.AbstractCommand;
import ml.sadriev.streamapilambda.constant.DataConstant;

import java.io.File;
import java.nio.file.Files;

/**
 * @author Andrey Sadriev
 */
@Component
public final class DataJsonClearCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-json-clear";
    }

    @Override
    public String description() {
        return "Remove JSON file.";
    }

    @Override
    public void execute() throws Exception {
        final File file = new File(DataConstant.FILE_JSON);
        Files.deleteIfExists(file.toPath());
    }
}