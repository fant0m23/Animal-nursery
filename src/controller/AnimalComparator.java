package controller;

import models.Animals;
import java.util.Comparator;

public class AnimalComparator implements Comparator<Animals> {

    @Override
    public int compare(Animals o1, Animals o2) {
        return Long.compare(o1.getBirthdate(), o2.getBirthdate());
    }

//    @Override
//    public int compare(Animals o1, Animals o2) {
//        if (o1.getBirthdate() > o2.getBirthdate()) {
//            return 1;
//        } else if (o1.getBirthdate() == o2.getBirthdate()) { return 0;
//        } else return -1;
//    }
}
