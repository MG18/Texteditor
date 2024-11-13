import java.util.TreeMap;

public class Textmodifier {
    private String dummy = "dummy";



    public void add(TreeMap<Integer, String> text, Integer n, String s){
        text.put(n, s);
    }

    public void remove(TreeMap<Integer, String> text, Integer n){
        text.remove(n);
    }

    public void replace(TreeMap<Integer, String> text, Integer n, String s){

    }

    public void dummy(TreeMap<Integer, String> text, Integer n){
        text.put(n, dummy);
    }
}
