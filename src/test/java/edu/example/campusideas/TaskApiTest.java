package edu.example.campusideas;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
class TaskApiTest {
    @Autowired private MockMvc mvc;
    @Autowired private TaskStore store;
    @Test void getReturnsList() throws Exception {
        mvc.perform(get("/api/tasks")).andExpect(status().isOk()).andExpect(jsonPath("$").isArray());
    }
    @Test void postCreatesTaskWithPriority() throws Exception {
        mvc.perform(post("/api/tasks").contentType(MediaType.APPLICATION_JSON)
            .content("{\"title\":\"Start a coding club\",\"priority\":\"high\"}"))
            .andExpect(status().isCreated()).andExpect(jsonPath("$.id").isNumber())
            .andExpect(jsonPath("$.title").value("Start a coding club"))
            .andExpect(jsonPath("$.priority").value("high"))
            .andExpect(jsonPath("$.completed").value(false));
    }
    @Test void spacesOnlyTitleAddsNoTask() throws Exception {
        int before = store.findAll().size();
        mvc.perform(post("/api/tasks").contentType(MediaType.APPLICATION_JSON)
            .content("{\"title\":\"   \",\"priority\":\"medium\"}"))
            .andExpect(status().isBadRequest());
        assertEquals(before, store.findAll().size());
    }
    @Test void invalidPriorityAddsNoTask() throws Exception {
        int before = store.findAll().size();
        mvc.perform(post("/api/tasks").contentType(MediaType.APPLICATION_JSON)
            .content("{\"title\":\"Valid title\",\"priority\":\"urgent\"}"))
            .andExpect(status().isBadRequest());
        assertEquals(before, store.findAll().size());
    }
    @Test void browserPreflightAllowsReact() throws Exception {
        mvc.perform(options("/api/tasks").header("Origin", "http://localhost:5173")
            .header("Access-Control-Request-Method", "POST")
            .header("Access-Control-Request-Headers", "content-type"))
            .andExpect(status().isOk())
            .andExpect(header().string("Access-Control-Allow-Origin", "http://localhost:5173"));
    }
}
