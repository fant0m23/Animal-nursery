
import models.Animals;
import models.Cat;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите дату рождения в формате ГГГГ-ММ-ДД");

        Date date1 = Date.valueOf("2020-12-15");
        Animals cat = new Cat("Мурка", 'к', "2019-05-24");
        cat.addCommands("сидеть, мяу");
        System.out.println(cat);
        cat.addCommands("лежать");
        long now = System.currentTimeMillis();
        long now2 = 253402289972542L;
        Date date2 = new Date(now);
        Date date3 = new Date(now2);
        System.out.println(date1);
        System.out.println(now);
        System.out.println(date2);
        System.out.println(date3);
        System.out.println(cat);
        cat.dropAllCommands();
        cat.addCommands("прыг");
        System.out.println(cat);
    }
}