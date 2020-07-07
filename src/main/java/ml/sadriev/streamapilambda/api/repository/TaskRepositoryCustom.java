package ml.sadriev.streamapilambda.api.repository;

import java.util.Collection;
import ml.sadriev.streamapilambda.model.Task;

public interface TaskRepositoryCustom {

    Task createTask(String name);

    void merge(Task... tasks);

    void merge(Collection<Task> tasks);

    void load(Collection<Task> tasks);

    void load(Task... tasks);

    Task merge(Task task);
}
