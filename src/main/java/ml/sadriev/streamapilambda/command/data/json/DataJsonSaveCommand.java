package ml.sadriev.streamapilambda.command.data.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import javax.annotation.Resource;
import ml.sadriev.streamapilambda.api.service.IDomainService;
import ml.sadriev.streamapilambda.command.AbstractCommand;
import ml.sadriev.streamapilambda.constant.DataConstant;
import ml.sadriev.streamapilambda.model.Domain;
import org.springframework.stereotype.Component;

/**
 * @author Andrey Sadriev
 */
@Component
public final class DataJsonSaveCommand extends AbstractCommand {

    @Resource
    private IDomainService domainService;

    @Override
    public String command() {
        return "data-json-save";
    }

    @Override
    public String description() {
        return "Save Domain to JSON.";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[DATA JSON SAVE]");
        final Domain domain = new Domain();
        domainService.export(domain);
        final ObjectMapper objectMapper = new ObjectMapper();
        final ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        final String json = objectWriter.writeValueAsString(domain);
        final byte[] data = json.getBytes(StandardCharsets.UTF_8);
        final File file = new File(DataConstant.FILE_JSON);
        Files.write(file.toPath(), data);
        System.out.println("[OK]");
    }
}