package controller;

import models.Animals;

public interface RegistryFunctional {
    void addAnimal(Animals a);
    void getQuantity();
    void printSortedRegistry();
    void start();
}
