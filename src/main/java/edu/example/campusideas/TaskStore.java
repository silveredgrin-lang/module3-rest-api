package edu.example.campusideas;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class TaskStore {
    private final List<Task> tasks = new ArrayList<>();
    private long nextId = 1;
    public synchronized List<Task> findAll() { return List.copyOf(tasks); }
    public synchronized Task add(TaskRequest request) {
        Task task = new Task(nextId++, request.title().trim(), request.priority(), false);
        tasks.add(task);
        return task;
    }
}
