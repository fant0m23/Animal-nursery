import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("сидеть");
        set.add("лежать");

        Animals one = new Animals("Boss", LocalDateTime.now(), set);

        System.out.println(one);
    }
}