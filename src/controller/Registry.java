package controller;

import models.*;
import view.RegistryUI;

import static view.Text.*;

import java.util.ArrayList;
import java.util.List;

public class Registry implements RegistryFunctional {
    private final List<Animals> registry = new ArrayList<>();
    private RegistryUI userInput = new RegistryUI();

    public void start() {
        userInput.textOnConsole(HELLO);
        boolean flag = true;
        char userChoice;
        while (flag) {
            userChoice = userInput.getAction();
            switch (userChoice) {
                case '1':
                    userInput.textOnConsole(ADDNAME);
                    String name = userInput.getUserStr2();
                    char type = userInput.getType();
                    userInput.textOnConsole(ADDBDAY);
                    String bday = userInput.getUserStr2();
                    addAnimal(getNewAnimal(name, type, bday));
                    break;
                case '2':
                    printSortedRegistry();
                    break;
                case '3':
                    userInput.textOnConsole(ADDNAME);
                    String name2 = userInput.getUserStr2();
                    printCommands(name2);
                    break;
                case '4':
                    userInput.textOnConsole(ADDNAME);
                    String name3 = userInput.getUserStr2();
                    userInput.textOnConsole(ADDCOMM);
                    String skill = userInput.getUserStr();
                    addSkill(name3, skill);
                    break;
                case '5':
                    getQuantity();
                    break;
                case 'q':
                    userInput.textOnConsole(BYE);
                    flag = false;
                    break;
            }
        }
        userInput.closeScanner();
    }

    public Animals getNewAnimal(String name, char type, String date) {
        return switch (type) {
            case 'к' -> new Cat(name, date);
            case 'с' -> new Dog(name, date);
            case 'х' -> new Hamster(name, date);
            case 'л' -> new Horse(name, date);
            case 'о' -> new Donkey(name, date);
            case 'в' -> new Camel(name, date);
            default -> null;
        };
    }

    public void printCommands(String name2) {
        for (Animals a : registry) {
            if (a.getName().equalsIgnoreCase(name2)) {
                if (a.getCommands().isEmpty()) System.out.println(name2 + "пока что ничего не умеет :(");
                else System.out.println(a.getCommands());
            }
        }
    }

    public void addSkill(String name3, String skill) {
        for (Animals a : registry) {
            if (a.getName().equalsIgnoreCase(name3)) a.addCommands(skill);
        }
    }

    @Override
    public void addAnimal(Animals a) {
        this.registry.add(a);
    }

    @Override
    public void getQuantity() {
        if (this.registry.isEmpty()) System.out.println("В реестре животные ещё не регистрировались");
        else System.out.println("Всего в реестре было зарегистрировано животных: " + registry.get(0).getCounter());
    }

    @Override
    public void printSortedRegistry() {
        if (this.registry.isEmpty()) System.out.println("Реестр пуст");
        else {
            List<Animals> registrySorted = new ArrayList<>(this.registry);
            registrySorted.sort(new AnimalComparator());
            for (Animals a : registrySorted) {
                System.out.println(a);
            }
        }
    }
}
