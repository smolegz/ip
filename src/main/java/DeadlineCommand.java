import java.util.*;
import java.io.*;

public class DeadlineCommand extends Command {

    public static final String COMMAND = "deadline";
    private final String name;
    private final String by;

    public DeadlineCommand(String name, String by) {
        this.name = name;
        this.by = by;
    }

    @Override
    public void execute() throws DukeException {
        if (name.isEmpty()) {
            Ui.emptyTaskMessage();
        } else if (name.compareTo(by) == 0) {
            Ui.invalidFormat();
        } else {
            Deadline deadline = new Deadline(name, by.trim());
            tasks.add(deadline);
            Ui.printVLine();
            System.out.println("Got it! Deadline has been added:\n" + deadline + "\nNow you have "
                    + tasks.getList().size() + " tasks in the list.");
            Ui.printVLine();
        }
    }
}
