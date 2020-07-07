package ml.sadriev.streamapilambda.command.task;

import javax.annotation.Resource;
import ml.sadriev.streamapilambda.api.service.ITaskService;
import org.springframework.stereotype.Component;
import ml.sadriev.streamapilambda.command.AbstractCommand;
import ml.sadriev.streamapilambda.controller.Bootstrap;

/**
 * @author Andrey Sadriev
 */
@Component
public final class TaskCreateCommand extends AbstractCommand {

    @Resource
    private Bootstrap bootstrap;
    @Resource
    private ITaskService taskService;

    @Override
    public String command() {
        return "task-create";
    }

    @Override
    public String description() {
        return "Create new task.";
    }

    @Override
    public void execute() {
        System.out.println("[TASK CREATE]");
        System.out.println("ENTER NAME:");
        final String name = bootstrap.nextLine();
        taskService.createTask(name);
        System.out.println("[OK]");
        System.out.println();
    }
}
