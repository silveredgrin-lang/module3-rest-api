package edu.example.campusideas;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST}, allowedHeaders = "Content-Type")
public class TaskController {
    private final TaskStore store;
    public TaskController(TaskStore store) { this.store = store; }
    @GetMapping
    public List<Task> getTasks() { return store.findAll(); }
    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(store.add(request));
    }
}
