
import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class Animals {
    private int id = 0;
    private String name;
    private LocalDateTime birthdate;
    private HashSet<String> execCommands;

    public Animals(String name, LocalDateTime birthdate, HashSet<String> execCommands) {
        this.name = name;
        this.birthdate = birthdate;
        this.execCommands = execCommands;
        this.id ++;
    }

    @Override
    public String toString() {
        return String.format("%d %s %tD %s", id, name, birthdate, execCommands);
    }
}