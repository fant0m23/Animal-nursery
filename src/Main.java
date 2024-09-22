
import controller.Registry;
import controller.RegistryService;
import models.Animals;
import models.Cat;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите дату рождения в формате ГГГГ-ММ-ДД");
        Date date1 = Date.valueOf("2020-12-15");
        RegistryService reestr = new Registry();
        Animals cat = new Animals("Мурка", 'к', "2019-05-24");
        cat.addCommands("сидеть, мяу");
        cat.addCommands("лежать");
//        long now = System.currentTimeMillis();
//        long now2 = 253402289972542L;
//        Date date2 = new Date(now);
//        Date date3 = new Date(now2);
//        cat.dropAllCommands();
//        cat.addCommands("прыг");
        System.out.println(reestr.getQuantity());
        reestr.addAnimal(cat);
        System.out.println(reestr.getQuantity());
        Animals cat2 = new Animals("Барсик", 'к', "2012-06-12");
        Animals cat3 = new Animals("Босс", 'к', "2018-04-05");
        cat2.addCommands("прыг, лежать");
        cat.addCommands("прыг, мяу");
        reestr.addAnimal(cat2);
        reestr.addAnimal(cat3);
        System.out.println(reestr.getQuantity());

        reestr.printSortedRegistry();
    }
}