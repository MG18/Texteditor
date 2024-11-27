import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestDummy {
    Document document;
    Dummy dummy;
    Add add;
    @BeforeEach
    public void setUp() {
        document = new Document();
        dummy = new Dummy();
        add = new Add();
    }
    @Test
    public void testDummyIntoEmptyDocument() {
        dummy.dummy(document, 1);
        assertTrue(document.checkIndexExistence(1));
        assertEquals("TestDummy", document.getText(1));
    }

    @Test
    public void testDummyIntoFilledDocument() {
        dummy.dummy(document, 1);
        dummy.dummy(document, 2);
        assertTrue(document.checkIndexExistence(1));
        assertTrue(document.checkIndexExistence(2));
        assertEquals("TestDummy", document.getText(1));
        assertEquals("TestDummy", document.getText(2));
    }

    @Test
    public void testDummyIntoFilledDocumentFirstLine() {
        add.add(document, 1, "Row1");
        add.add(document, 2, "Row2");
        dummy.dummy(document, 1);
        assertTrue(document.checkIndexExistence(1));
        assertTrue(document.checkIndexExistence(2));
        assertTrue(document.checkIndexExistence(3));
        assertEquals("TestDummy", document.getText(1));
        assertEquals("Row1", document.getText(2));
        assertEquals("Row2", document.getText(3));
    }

    @Test
    public void testDummyIntoFilledDocumentMiddleLine() {
        add.add(document, 1, "Row1");
        add.add(document, 2, "Row2");
        dummy.dummy(document, 2);
        assertTrue(document.checkIndexExistence(1));
        assertTrue(document.checkIndexExistence(2));
        assertTrue(document.checkIndexExistence(3));
        assertEquals("Row1", document.getText(1));
        assertEquals("TestDummy", document.getText(2));
        assertEquals("Row2", document.getText(3));
    }

    @Test
    public void testDummyIntoEmptyDocumentNullIndex() {
        dummy.dummy(document, null);
        assertTrue(document.checkIndexExistence(1));
    }

    @Test
    public void testDummyIntoFilledDocumentNullIndex() {
        dummy.dummy(document, null);
        dummy.dummy(document, null);
        assertTrue(document.checkIndexExistence(1));
        assertTrue(document.checkIndexExistence(2));
        assertEquals("TestDummy", document.getText(1));
        assertEquals("TestDummy", document.getText(2));

    }

}

