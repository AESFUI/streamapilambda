package ml.sadriev.streamapilambda.command.project;

import javax.annotation.Resource;
import ml.sadriev.streamapilambda.api.service.IProjectService;
import ml.sadriev.streamapilambda.controller.Bootstrap;
import org.springframework.stereotype.Component;
import ml.sadriev.streamapilambda.command.AbstractCommand;

/**
 * @author Andrey Sadriev
 */
@Component
public final class ProjectCreateCommand extends AbstractCommand {

    @Resource
    private Bootstrap bootstrap;
    @Resource
    private IProjectService projectService;

    @Override
    public String description() {
        return "Create new project.";
    }

    @Override
    public String command() {
        return "project-create";
    }

    @Override
    public void execute() {
        System.out.println("[PROJECT CREATE]");
        System.out.println("ENTER NAME:");
        final String name = bootstrap.nextLine();
        projectService.createProject(name);
        System.out.println("[OK]");
        System.out.println();
    }

}
