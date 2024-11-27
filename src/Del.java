public class Del extends Commands{

    public void delete(Document document, Integer index){

        if(!document.checkDocumentEmpty() && index >= document.getDocument().lastKey()){
            document.getDocument().remove(document.getDocument().lastKey());
        } else if (document.checkDocumentEmpty() && document.checkIndexExistence(index)) {
            document.getDocument().remove(index);
        } else if (!document.checkDocumentEmpty() && document.checkIndexExistence(index)) {
            document.getDocument().remove(index);
            for (int i = index; i < document.getDocument().lastKey(); i++) {
                document.shiftRow(i+1, i);
            }

        }
    }
}
