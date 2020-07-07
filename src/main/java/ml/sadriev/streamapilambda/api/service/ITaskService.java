package ml.sadriev.streamapilambda.api.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import ml.sadriev.streamapilambda.model.Task;

/**
 * @author Andrey Sadriev
 */
public interface ITaskService {

    Task createTask(String name);

    Task getTaskById(String id);

    Task merge(Task task);

    int removeTaskByName(String name);

    List<Task> getListTask();

    void clear();

    Task createTaskByProject(String projectId, String taskName);

    Task getByOrderIndex(Integer orderIndex);

    void merge(Task... tasks);

    void load(Task... tasks);

    void load(Collection<Task> tasks);

    Map<String, Date> getTaskDateMapFromTaskAfterDate(Date beginDate, String line);

    void doSomeNonsense();
}
