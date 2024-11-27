import java.util.TreeMap;
import java.util.logging.Logger;

public class Document {
    private Logger logger;
    private TreeMap<Integer, String> document;


    public Document() {
        logger = Logger.getLogger(Document.class.getName());
        document = new TreeMap<Integer, String>();
    }

    public String getText(Integer index){
        return document.get(index);
    }

    public TreeMap<Integer, String> getDocument() {
        return document;
    }

    public void shiftRow(Integer from, Integer to){
        String temp = document.get(from);
        document.remove(from);
        document.put(to, temp);
    }

    public boolean checkIndexExistence(Integer index) {
        return document.containsKey(index);
    }

    public boolean checkDocumentEmpty() {
        return this.document.isEmpty();
    }
}
