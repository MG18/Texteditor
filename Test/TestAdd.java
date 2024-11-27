import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestAdd {
    private Document document;
    private Add add;
    @BeforeEach
    public void setUp() {
        document = new Document();
        add = new Add();
    }

    @Test
    public void testAddIntoEmptyDocument() {
        add.add(document, 1, "Row1");
        assertTrue(document.checkIndexExistence(1));
        assertEquals("Row1", document.getText(1));
    }

    @Test
    public void testAddIntoFilledDocument() {
        add.add(document, 1, "Row1");
        add.add(document, 2, "Row2");
        assertTrue(document.checkIndexExistence(1));
        assertTrue(document.checkIndexExistence(2));
        assertEquals("Row1", document.getText(1));
        assertEquals("Row2", document.getText(2));
    }

    @Test
    public void testAddIntoFilledDocumentFirstLine() {
        add.add(document, 1, "Row1");
        add.add(document, 2, "Row2");
        add.add(document, 1, "NewRow1");
        assertTrue(document.checkIndexExistence(1));
        assertTrue(document.checkIndexExistence(2));
        assertTrue(document.checkIndexExistence(3));
        assertEquals("NewRow1", document.getText(1));
        assertEquals("Row1", document.getText(2));
        assertEquals("Row2", document.getText(3));
    }

    @Test
    public void testAddIntoFilledDocumentMiddleLine() {
        add.add(document, 1, "Row1");
        add.add(document, 2, "Row2");
        add.add(document, 2, "NewRow2");
        assertTrue(document.checkIndexExistence(1));
        assertTrue(document.checkIndexExistence(2));
        assertTrue(document.checkIndexExistence(3));
        assertEquals("Row1", document.getText(1));
        assertEquals("NewRow2", document.getText(2));
        assertEquals("Row2", document.getText(3));
    }

    @Test
    public void testAddIntoEmptyDocumentNullIndex() {
        add.add(document, null, "Row1");
        assertTrue(document.checkIndexExistence(1));
    }

    @Test
    public void testAddIntoFilledDocumentNullIndex() {
        add.add(document, null, "Row1");
        add.add(document, null, "Row2");
        assertTrue(document.checkIndexExistence(1));
        assertTrue(document.checkIndexExistence(2));
        assertEquals("Row1", document.getText(1));
        assertEquals("Row2", document.getText(2));

    }

    @Test
    public void testAddIntoFilledDocumentMiddleLineWithMultipleRows(){
        add.add(document, 1, "Row1");
        add.add(document, 2, "Row2");
        add.add(document, 3, "Row3");
        add.add(document, 4, "Row4");
        add.add(document, 5, "Row5");
        add.add(document, 2, "NewRow2");

        assertTrue(document.checkIndexExistence(1));
        assertTrue(document.checkIndexExistence(2));
        assertTrue(document.checkIndexExistence(3));
        assertTrue(document.checkIndexExistence(4));
        assertTrue(document.checkIndexExistence(5));
        assertTrue(document.checkIndexExistence(6));

        assertEquals("Row1", document.getText(1));
        assertEquals("NewRow2", document.getText(2));
        assertEquals("Row2", document.getText(3));
        assertEquals("Row3", document.getText(4));
        assertEquals("Row4", document.getText(5));
        assertEquals("Row5", document.getText(6));
    }


    /*@Test
    public void testAddNegativeIndexIntoEmptyDocument(){
        add.add(document, -1, "Row1");

        assertTrue(document.getDocument().isEmpty());

    }*/

}
