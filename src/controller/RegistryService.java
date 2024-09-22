package controller;

import models.Animals;

public interface RegistryService {
    void addAnimal(Animals a);
    String getQuantity();
    void printSortedRegistry();
}
