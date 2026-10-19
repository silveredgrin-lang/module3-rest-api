package edu.example.campusideas;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
// Provided for Phase 1. Data resets when the application restarts.
@Service
public class IdeaStore {
    private final List<Idea> ideas = new ArrayList<>();
    private long nextId = 1;
    public IdeaStore() {
        ideas.add(new Idea(nextId++, "Start a coding club", "clubs"));
        ideas.add(new Idea(nextId++, "Create a campus garden", "environment"));
    }
    public synchronized List<Idea> findAll() {
        return List.copyOf(ideas);
    }
    public synchronized Idea add(IdeaRequest request) {
        Idea idea = new Idea(nextId++, request.title().trim(), request.category().trim());
        ideas.add(idea);
        return idea;
    }
}
