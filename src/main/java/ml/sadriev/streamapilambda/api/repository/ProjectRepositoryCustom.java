package ml.sadriev.streamapilambda.api.repository;

import java.util.Collection;
import ml.sadriev.streamapilambda.model.Project;

public interface ProjectRepositoryCustom {

    Project createProject(String name);

    Project merge(Project project);

    void merge(Collection<Project> projects);

    void merge(Project... projects);

    void load(Collection<Project> projects);

    void load(Project... projects);

    Project removeByOrderIndex(Integer orderIndex);
}
