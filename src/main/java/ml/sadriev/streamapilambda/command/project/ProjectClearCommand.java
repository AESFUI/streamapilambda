package ml.sadriev.streamapilambda.command.project;

import javax.annotation.Resource;
import ml.sadriev.streamapilambda.api.service.IProjectService;
import org.springframework.stereotype.Component;
import ml.sadriev.streamapilambda.command.AbstractCommand;

/**
 * @author Andrey Sadriev
 */
@Component
public final class ProjectClearCommand extends AbstractCommand {

    @Resource
    private IProjectService projectService;

    @Override
    public String command() {
        return "project-clear";
    }

    @Override
    public String description() {
        return "Remove all projects.";
    }

    @Override
    public void execute() {
        projectService.clear();
        System.out.println("[ALL PROJECTS REMOVED]");
    }
}
