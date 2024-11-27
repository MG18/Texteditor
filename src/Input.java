import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Input {
    private Scanner scanner;
    private static final String VALIDSYMBOLS = "^[a-zA-Z0-9äöüÄÖÜ.,:;\\-!? '()\"%@+*\\[\\]{}\\\\/&#$]*$";
    private String currentInput;
    private Integer currentIndex;
    private HashMap<String, CommandWord> commandSet = new HashMap<String, CommandWord>();
    private static Logger logger = Logger.getLogger(Input.class.getName());

    Input() {
        scanner = new Scanner(System.in);
        commandSet.put("replace", CommandWord.REPLACE);
        commandSet.put("add", CommandWord.ADD);
        commandSet.put("index", CommandWord.INDEX);
        commandSet.put("del", CommandWord.DEL);
        commandSet.put("dummy", CommandWord.DUMMY);
        commandSet.put("exit", CommandWord.EXIT);
        commandSet.put("format raw", CommandWord.FORMAT_RAW);
        commandSet.put("format fix", CommandWord.FORMAT_FIX);
        commandSet.put("print", CommandWord.PRINT);
    }

    public static void main(String[] args) {
        Input input = new Input();
        input.getUserInput();
        input.checkCommandSet();
        input.splitInput();
        System.out.println(input.getCurrentInput() + " " +  input.getCurrentIndex() + " " +input.checkInputValidity(input.currentInput) + " Command exists: " + input.checkCommandSet());
    }

    /**
     * Die Methode nimmt den Userinput und speichert ihn in der Variable currentInput
     */

    public void getUserInput() {
        this.currentInput = scanner.nextLine().trim().toLowerCase();
    }
    /**
     * Die Methode gibt die Variable currentInput zurück
     */

    public String getCurrentInput() {
        return this.currentInput;
    }

    /**
     * Die Methode prüft ob der Userinput die erlaubten Zeichen enthält
     */
    public boolean checkInputValidity(String input) {
        Pattern pattern = Pattern.compile(VALIDSYMBOLS);
        return pattern.matcher(input).matches();

    }

    /**
     * Die Methode teilt den Userinput in den Befehl und die Position
     */
    public void splitInput(){
        String[] splitInput = currentInput.split("\\s+");
        currentInput = splitInput[0];
        if(splitInput.length > 1 && splitInput[1].matches("[0-9]+")){
            currentIndex = Integer.parseInt(splitInput[1]);
        }
        //else if(spl)

    }

    public boolean checkCommandSet() {
        if (commandSet.get(currentInput) != null) {
            return true;
        }
        return false;
    }

        public void checkPositonCommandSet () {
            System.out.println("Position is valid");
        }


        public Integer getCurrentIndex() {
            return currentIndex;
        }

    }