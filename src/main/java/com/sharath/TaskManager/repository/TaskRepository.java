package com.sharath.TaskManager.repository;

import com.sharath.TaskManager.model.Task;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskRepository {

    private final Map<Long, Task> tasks = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Collection<Task> findAll() {
        return tasks.values();
    }

    public Task findById(Long id) {
        return tasks.get(id);
    }

    public Task save(Task task) {
        if(task.getId() == null) {
            task.setId(idGenerator.getAndIncrement());
        }
        tasks.put(task.getId(), task);
        return task;
    }

    public void delete(Long id) {
        tasks.remove(id);
    }

    public boolean exists(Long id) {
        return tasks.containsKey(id);
    }
}
