package ml.sadriev.streamapilambda.api.repository;

import ml.sadriev.streamapilambda.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andrey Sadriev
 */
public interface ProjectRepository extends JpaRepository<Project, String>, ProjectRepositoryCustom {

    Project findProjectById(String id);

    void deleteProjectById(String id);

    void deleteProjectByName(String name);
}
