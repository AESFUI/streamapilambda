package ml.sadriev.streamapilambda.command.data.bin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import javax.annotation.Resource;
import ml.sadriev.streamapilambda.api.service.IProjectService;
import ml.sadriev.streamapilambda.api.service.ITaskService;
import ml.sadriev.streamapilambda.command.AbstractCommand;
import ml.sadriev.streamapilambda.constant.DataConstant;
import ml.sadriev.streamapilambda.model.Project;
import ml.sadriev.streamapilambda.model.Task;
import org.springframework.stereotype.Component;

/**
 * @author Andrey Sadriev
 */
@Component
public final class DataBinarySaveCommand extends AbstractCommand {

    @Resource
    private IProjectService projectService;
    @Resource
    private ITaskService taskService;

    @Override
    public String command() {
        return "data-bin-save";
    }

    @Override
    public String description() {
        return "Load data from binary file.";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[DATA BINARY SAVE]");
        final Project[] projects = projectService.getListProject().toArray(new Project[]{});
        final Task[] tasks = taskService.getListTask().toArray(new Task[]{});

        final File file = new File(DataConstant.FILE_BINARY);
        Files.deleteIfExists(file.toPath());
        Files.createFile(file.toPath());

        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(projects);
        objectOutputStream.writeObject(tasks);
        objectOutputStream.close();
        fileOutputStream.close();

        System.out.println("[OK]");
        System.out.println();
    }
}
