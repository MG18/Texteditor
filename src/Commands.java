import java.util.logging.Logger;

public class Commands {
    private Logger logger;

    public boolean checkIndexNull(Integer index) {return index == null; }

    public Commands() {
        logger = Logger.getLogger(Commands.class.getName());
    }



}
