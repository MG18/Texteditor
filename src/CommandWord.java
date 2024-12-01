import java.util.HashMap;

public enum CommandWord {
    ADD("add"), DEL("del"), FORMAT_FIX("format fix"), FORMAT_RAW("foramt raw"), INDEX("index"), REPLACE("replace"), DUMMY("dummy"), PRINT("print"), EXIT("exit");

    String command;
    private static final HashMap<String,CommandWord> ENUM_MAP;

    CommandWord(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }

    static {
        ENUM_MAP = new HashMap<String, CommandWord>();
        for(CommandWord cw : CommandWord.values()) {
            ENUM_MAP.put(cw.getCommand(), cw);
        }
    }

    public static CommandWord get (String name) {
        return ENUM_MAP.get(name.toLowerCase());
    }
}
