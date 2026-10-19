package edu.example.campusideas;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// API/component test: exercises routing and JSON through MockMvc, without a live network server.
@SpringBootTest
@AutoConfigureMockMvc
class IdeaApiTest {
    @Autowired private MockMvc mvc;
    @Test
    void validPostReturnsCreatedIdea() throws Exception {
        // Use mvc.perform(post("/api/ideas").contentType(MediaType.APPLICATION_JSON)
        //     .content(...)) and check status().isCreated(), $.id, $.title, $.category.
        // Do not assert an exact id; another test may have created an idea.
        mvc.perform(post("/api/ideas")
        .contentType(MediaType.APPLICATION_JSON)
        .content("""
            {
                "title": "Create a student tech lab",
                "category": "technology"
            }
            """))
    .andExpect(status().isCreated())
    .andExpect(jsonPath("$.id").exists())
    .andExpect(jsonPath("$.title").value("Create a student tech lab"))
    .andExpect(jsonPath("$.category").value("technology"));
    }
}
