package edu.example.campusideas;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
// This describes the JSON students send. The server assigns the id.
public record IdeaRequest(
    @NotBlank @Size(max = 80) String title,
    @NotBlank @Size(max = 30) String category
) {}
