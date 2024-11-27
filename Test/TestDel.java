import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestDel {

    private Document document;
    private Del del;
    @BeforeEach
    public void setUp() {
        document = new Document();
        del = new Del();
    }

    @Test
    public void testDeleteFromEmptyDocument() {
        del.delete(document, 1);
        assertFalse(document.checkIndexExistence(1));
        assertTrue(document.checkDocumentEmpty());
    }

    @Test
    public void testDeleteFromEmptyDocumentWithNegativeIndex() {
        del.delete(document, -1);
        assertFalse(document.checkIndexExistence(1));
        assertTrue(document.checkDocumentEmpty());
    }

    @Test
    public void testDeleteFromFilledDocumentOneElement() {
        document.getDocument().put(1, "Row1");
        del.delete(document, 1);
        assertFalse(document.checkIndexExistence(1));
        assertTrue(document.checkDocumentEmpty());
    }

    @Test
    public void testDeleteFromFilledDocumentMultipleElementsLastRow() {
        document.getDocument().put(1, "Row1");
        document.getDocument().put(2, "Row2");
        del.delete(document, 2);
        assertTrue(document.checkIndexExistence(1));
        assertFalse(document.checkIndexExistence(2));
        assertEquals("Row1", document.getText(1));
    }


    @Test
    public void testDeleteFromFilledDocumentMultipleElementsFirstRow() {
        document.getDocument().put(1, "Row1");
        document.getDocument().put(2, "Row2");
        del.delete(document, 1);
        assertTrue(document.checkIndexExistence(1));
        assertFalse(document.checkIndexExistence(2));
        assertEquals("Row2", document.getText(1));
    }


    @Test
    public void testDeleteFromFilledDocumentMultipleElementsMiddleRow() {
        document.getDocument().put(1, "Row1");
        document.getDocument().put(2, "Row2");
        document.getDocument().put(3, "Row3");
        del.delete(document, 2);
        assertTrue(document.checkIndexExistence(1));
        assertTrue(document.checkIndexExistence(2));
        assertFalse(document.checkIndexExistence(3));
        assertEquals("Row1", document.getText(1));
        assertEquals("Row3", document.getText(2));
    }

    @Test
    public void testMultipleDeletesFromFilledDocumentMultipleElements() {
        document.getDocument().put(1, "Row1");
        document.getDocument().put(2, "Row2");
        document.getDocument().put(3, "Row3");
        document.getDocument().put(4, "Row4");
        document.getDocument().put(5, "Row5");

        del.delete(document, 2);
        assertTrue(document.checkIndexExistence(1));
        assertTrue(document.checkIndexExistence(2));
        assertTrue(document.checkIndexExistence(3));
        assertTrue(document.checkIndexExistence(4));
        assertFalse(document.checkIndexExistence(5));
        assertEquals("Row1", document.getText(1));
        assertEquals("Row3", document.getText(2));
        assertEquals("Row4", document.getText(3));
        assertEquals("Row5", document.getText(4));

        del.delete(document, 3);
        assertTrue(document.checkIndexExistence(1));
        assertTrue(document.checkIndexExistence(2));
        assertTrue(document.checkIndexExistence(3));
        assertFalse(document.checkIndexExistence(4));
        assertFalse(document.checkIndexExistence(5));
        assertEquals("Row1", document.getText(1));
        assertEquals("Row3", document.getText(2));
        assertEquals("Row5", document.getText(3));

        del.delete(document, 1);
        assertTrue(document.checkIndexExistence(1));
        assertTrue(document.checkIndexExistence(2));
        assertFalse(document.checkIndexExistence(3));
        assertFalse(document.checkIndexExistence(4));
        assertFalse(document.checkIndexExistence(5));
        assertEquals("Row3", document.getText(1));
        assertEquals("Row5", document.getText(2));

    }


}
