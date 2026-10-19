package edu.example.campusideas;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GreetingController {
    @GetMapping("/api/hello")
    public Map<String, String> hello() {
        // TODO 1: Personalize the message. Keep the JSON key "message"
        //GET /api/ideas: return the list of ideas.
        //POST /api/ideas: receive and create an idea.
        //
        return Map.of("message", "Hello from Lisa's Campus Idea Board!");
    }
}

