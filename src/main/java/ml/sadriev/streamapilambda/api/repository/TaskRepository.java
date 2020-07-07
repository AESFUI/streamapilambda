package ml.sadriev.streamapilambda.api.repository;

import ml.sadriev.streamapilambda.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Andrey Sadriev
 */
public interface TaskRepository extends JpaRepository<Task, String>, TaskRepositoryCustom {

    int deleteTaskByName(String name);

    @Query(value = "SELECT * from task LIMIT 1 OFFSET 0", nativeQuery=true)
    Task findTaskFirst();
}