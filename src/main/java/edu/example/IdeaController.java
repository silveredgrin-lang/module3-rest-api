package edu.example.campusideas;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
@RestController
@RequestMapping("/api/ideas")
public class IdeaController {
    private final IdeaStore store;
    public IdeaController(IdeaStore store) {
        this.store = store;
    }
    // TODO 2: Add the HTTP mapping for reading ideas.
    @GetMapping
public List<Idea> getIdeas() {
    return store.findAll();
}
        

    
    // TODO 4: Add the HTTP mapping for creating an idea.
    @PostMapping
public ResponseEntity<Idea> createIdea(
        @Valid @RequestBody IdeaRequest request) {

    Idea createdIdea = store.add(request);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(createdIdea);
    }
}
