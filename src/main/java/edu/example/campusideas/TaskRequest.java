package edu.example.campusideas;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
public record TaskRequest(
    @NotBlank @Size(max = 80) String title,
    @NotBlank @Pattern(regexp = "low|medium|high") String priority
) {}
