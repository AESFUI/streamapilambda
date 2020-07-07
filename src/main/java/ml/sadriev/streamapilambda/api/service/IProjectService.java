package ml.sadriev.streamapilambda.api.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import ml.sadriev.streamapilambda.model.Project;

/**
 * @author Andrey Sadriev
 */
public interface IProjectService {

    Project createProject(String name);

    Project merge(Project project);

    Project getProjectById(String id);

    void removeProjectByName(String name);

    List<Project> getListProject();

    void clear();

    void merge(Project... projects);

    void load(Collection<Project> projects);

    void load(Project... projects);

    Project removeByOrderIndex(Integer orderIndex);

    Project findProjectById(String id);

    Set<String> findFirstThreeNamesFromProjectById(String... ids);
}
