package edu.example.campusideas;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// True unit tests: no Spring context, HTTP client, or server is involved.
class IdeaStoreTest {
    @Test void freshStoreContainsTwoSeedIdeas() {
        IdeaStore store = new IdeaStore();
        assertEquals(2, store.findAll().size());
    }
    @Test
void addingIdeaStoresItsTitleAndCategory() {
    IdeaStore store = new IdeaStore();

    IdeaRequest request = new IdeaRequest(
        "Create a student tech lab",
        "technology"
    );

    Idea idea = store.add(request);

    assertEquals("Create a student tech lab", idea.title());
    assertEquals("technology", idea.category());
    assertTrue(store.findAll().contains(idea));
}
    @Test
void twoNewIdeasReceiveDifferentIds() {
    IdeaStore store = new IdeaStore();

    Idea first = store.add(
        new IdeaRequest("Start a book club", "clubs")
    );

    Idea second = store.add(
        new IdeaRequest("Build a study room", "facilities")
    );

    assertNotEquals(first.id(), second.id());
    assertNotEquals(1, first.id());
    assertNotEquals(2, first.id());
    assertNotEquals(1, second.id());
    assertNotEquals(2, second.id());
    assertEquals(4, store.findAll().size());
}
}
