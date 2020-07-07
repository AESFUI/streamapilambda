package ml.sadriev.streamapilambda.command.data.bin;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.annotation.Resource;
import ml.sadriev.streamapilambda.api.service.IProjectService;
import ml.sadriev.streamapilambda.api.service.ITaskService;
import ml.sadriev.streamapilambda.command.AbstractCommand;
import ml.sadriev.streamapilambda.constant.DataConstant;
import org.springframework.stereotype.Component;
import ml.sadriev.streamapilambda.model.Project;
import ml.sadriev.streamapilambda.model.Task;

/**
 * @author Andrey Sadriev
 */
@Component
public final class DataBinaryLoadCommand extends AbstractCommand {

    @Resource
    private IProjectService projectService;
    @Resource
    private ITaskService taskService;

    @Override
    public String command() {
        return "data-bin-load";
    }

    @Override
    public String description() {
        return "Save data to binary file.";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[DATA BINARY LOAD]");
        final FileInputStream fileInputStream = new FileInputStream(DataConstant.FILE_BINARY);
        final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        loadProjects(objectInputStream.readObject());
        loadTasks(objectInputStream.readObject());
        objectInputStream.close();
        fileInputStream.close();
        System.out.println("[OK]");
    }

    private void loadProjects(final Object value) {
        if (!(value instanceof Project[])) return;
        final Project[] projects = (Project[]) value;
        projectService.load(projects);
    }

    private void loadTasks(final Object value) {
        if (!(value instanceof Task[])) return;
        final Task[] tasks = (Task[]) value;
        taskService.load(tasks);
    }
}