package controller;

import models.Animals;

import java.util.ArrayList;
import java.util.List;

public class Registry implements RegistryService {
    private final List<Animals> registry = new ArrayList<>();

    public void start() {


    }

    @Override
    public void addAnimal(Animals a) {
        this.registry.add(a);
    }

    @Override
    public String getQuantity() {
        if (this.registry.isEmpty()) return "В реестре животные ещё не регистрировались";
        return String.format("Всего в реестре было зарегистрировано животных: %d", registry.get(0).getCounter());
    }

    @Override
    public void printSortedRegistry() {
        List<Animals> registrySorted = new ArrayList<>(this.registry);
        registrySorted.sort(new AnimalComparator());
        for (Animals a : registrySorted) {
            System.out.println(a);
        }
    }
}
