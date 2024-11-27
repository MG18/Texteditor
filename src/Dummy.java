public class Dummy extends Commands{
    private static final String DUMMY = "TestDummy";

    public Dummy () {
        super();

    }

    public void dummy(Document document, Integer index) {
        // Wenn kein inhalt vorhanden ist, wird der text an index 1 hinzugefügt egal ob index null ist oder nicht.
        if (document.checkDocumentEmpty()) {
            document.getDocument().put(1, DUMMY);

        } else if (checkIndexNull(index) || index > document.getDocument().lastKey()) {
            document.getDocument().put(document.getDocument().lastKey()+1, DUMMY);
        }
        else if (index >= document.getDocument().firstKey() && index <= document.getDocument().lastKey()) {
            document.getDocument().put(document.getDocument().lastKey()+1, document.getDocument().get(document.getDocument().lastKey()));
            for (int i = document.getDocument().lastKey(); i > index; i--) {
                document.getDocument().put(i, document.getDocument().get(i-1));
            }
            document.getDocument().put(index, DUMMY);
        }        
    }

    
}
