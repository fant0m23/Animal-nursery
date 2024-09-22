
import controller.Registry;
import controller.RegistryFunctional;
import models.Animals;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Date date1 = Date.valueOf("2020-12-15");
        Registry reestr = new Registry();
        Animals cat = new Animals("Мурка", "2019-05-24");
        Animals cat2 = new Animals("Барсик", "2012-06-12");
        Animals cat3 = new Animals("Босс", "2018-04-05");
        cat.addCommands("сидеть, мяу");
        cat.addCommands("лежать");
        reestr.getQuantity();
//        long now = System.currentTimeMillis();
//        long now2 = 253402289972542L;
//        Date date2 = new Date(now);
//        Date date3 = new Date(now2);
//        cat.dropAllCommands();
//        cat.addCommands("прыг");
        cat2.addCommands("прыг, лежать");
        cat3.addCommands("прыг, мяу");
        reestr.addAnimal(cat);
        reestr.getQuantity();
        reestr.addAnimal(cat2);
        reestr.addAnimal(cat3);
        reestr.getQuantity();

        reestr.printSortedRegistry();
        System.out.println();

        reestr.start();

    }
}