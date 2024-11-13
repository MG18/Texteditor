import java.util.Scanner;

public class Input {
    private Scanner scanner;
    private  String currentInput;
    private Integer currentPosition;

    Input() {
        scanner = new Scanner(System.in);
    }

    /**
     * Die Methode nimmt den Userinput und speichert ihn in der Variable currentInput
     */

    public void getUserInput() {
        this.currentInput = scanner.nextLine();
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
    public void checkInputValidity() {

    }

    public void checkCommandSet(){

    }

    public void checkPositonCommandSet(){

    }
}
