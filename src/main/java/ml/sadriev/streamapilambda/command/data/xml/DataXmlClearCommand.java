package ml.sadriev.streamapilambda.command.data.xml;

import ml.sadriev.streamapilambda.command.AbstractCommand;
import ml.sadriev.streamapilambda.constant.DataConstant;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;

/**
 * @author Andrey Sadriev
 */
@Component
public final class DataXmlClearCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-xml-clear";
    }

    @Override
    public String description() {
        return "Remove XML file.";
    }

    @Override
    public void execute() throws Exception {
        final File file = new File(DataConstant.FILE_XML);
        Files.deleteIfExists(file.toPath());
    }
}
