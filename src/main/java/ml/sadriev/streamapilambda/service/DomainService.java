package ml.sadriev.streamapilambda.service;

import javax.annotation.Resource;
import ml.sadriev.streamapilambda.api.service.IDomainService;
import ml.sadriev.streamapilambda.api.service.IProjectService;
import ml.sadriev.streamapilambda.api.service.ITaskService;
import ml.sadriev.streamapilambda.model.Domain;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Andrey Sadriev
 */
@Service
public class DomainService implements IDomainService {

    @Resource
    private IProjectService projectService;
    @Resource
    private ITaskService taskService;

    @Override
    public void load(final Domain domain) {
        if (domain == null) return;
        projectService.load(domain.getProjects());
        taskService.load(domain.getTasks());
    }

    @Override
    @Transactional
    public void export(final Domain domain) {
        if (domain == null) return;
        domain.setProjects(projectService.getListProject());
        domain.setTasks(taskService.getListTask());
    }
}
