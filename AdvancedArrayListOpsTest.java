import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class AdvancedArrayListOpsTest {

    private AdvancedArrayListOps ops;

    @BeforeEach
    void setup() {
        ops = new AdvancedArrayListOps();
        ops.append("Apple");
        ops.append("Banana");
        ops.append("Cherry");
        ops.append("apple");  // duplicate in different case
    }

    @Test
    void testAppend() {
        ops.append("Date");
        assertTrue(ops.search("Date"));
    }

    @Test
    void testInsertValidIndex() {
        ops.insert(1, "Blueberry");
        ArrayList<String> result = ops.partialMatch("Blueberry");
        assertEquals(1, result.size());
        assertEquals("Blueberry", result.get(0));
    }

    @Test
    void testInsertInvalidIndex() {
        ops.insert(100, "X"); // should print "Invalid index!" but not throw
        assertFalse(ops.search("X"));
    }

    @Test
    void testSearch() {
        assertTrue(ops.search("Banana"));
        assertFalse(ops.search("Durian"));
    }

    @Test
    void testStartingWith() {
        ArrayList<String> result = ops.startingWith("A");
        assertEquals(2, result.size()); // Apple + apple
        assertTrue(result.contains("Apple"));
        assertTrue(result.contains("apple"));
    }

    @Test
    void testSortAscending() {
        ops.sortAscending();
        ArrayList<String> sorted = ops.startingWith(""); // get all sorted
        assertEquals("Apple", sorted.get(0));
        assertEquals("Cherry", sorted.get(3));
    }

    @Test
    void testSortDescending() {
        ops.sortDescending();
        ArrayList<String> sorted = ops.startingWith("");
        assertEquals("apple", sorted.get(0)); // lowercase 'apple' > uppercase
    }

    @Test
    void testRegexSearch() {
        ArrayList<String> result = ops.regexSearch("a.*"); // case-insensitive
        assertTrue(result.contains("Apple"));
        assertTrue(result.contains("apple"));
        assertTrue(result.contains("Banana"));
    }

    @Test
    void testRemoveDuplicates() {
        ops.append("Banana"); // duplicate
        ops.removeDuplicates();
        ArrayList<String> result = ops.startingWith("");
        assertEquals(4, result.size()); // should be 4 unique
    }

    @Test
    void testPartialMatch() {
        ArrayList<String> result = ops.partialMatch("err");
        assertEquals(1, result.size());
        assertEquals("Cherry", result.get(0));
    }

    @Test
    void testSortByLength() {
        ops.sortByLength();
        ArrayList<String> result = ops.startingWith("");
        assertEquals("Apple", result.get(0));  // length 5
        assertEquals("Banana", result.get(3)); // length 6
    }
}
