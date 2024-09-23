package controller;

import models.*;
import view.RegistryUI;

import static view.Text.*;

import java.util.ArrayList;
import java.util.List;

public class Registry {
    private final List<Animals> registry = new ArrayList<>();
    private final RegistryUI userInput = new RegistryUI();

    public void start() {
        userInput.textOnConsole(HELLO);
        boolean flag = true;
        char userChoice;
        while (flag) {
            userChoice = userInput.getAction();
            switch (userChoice) {
                case '1':
                    userInput.textOnConsole(ADDNAME);
                    String name = userInput.getUserStr();
                    char type = userInput.getType();
                    userInput.textOnConsole(ADDBDAY);
                    String bday = userInput.getDateSQL();
                    this.registry.add(createAnimal(name, type, bday));
                    break;
                case '2':
                    printSortedRegistry();
                    break;
                case '3':
                    if (this.registry.isEmpty()) System.out.println("Реестр пуст");
                    else printCommands(getCorrectName());
                    break;
                case '4':
                    if (this.registry.isEmpty()) System.out.println("Реестр пуст");
                    else {
                        String name3 = getCorrectName();
                        userInput.textOnConsole(ADDCOMM);
                        String skill = userInput.getUserStr();
                        addSkill(name3, skill);
                    }
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

    private Animals createAnimal(String name, char type, String date) {
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

    private String getCorrectName() {
        List<String> list = new ArrayList<>();
        for (Animals a : registry) {
            list.add(a.getName().toLowerCase());
        }
        while (true) {
            userInput.textOnConsole(ADDNAME);
            String name = userInput.getUserStr().toLowerCase();
            if (!list.contains(name)) System.out.println("Животного по кличке " + name + " в реестре нет.");
            else return name;
        }
    }

    private void printCommands(String name) {
        for (Animals a : registry) {
            if (a.getName().equalsIgnoreCase(name)) {
                if (a.getCommands().isEmpty()) System.out.println(name + " пока что ничего не умеет :(");
                else System.out.println(a.getCommands());
            }
        }
    }

    private void addSkill(String name3, String skill) {
        for (Animals a : registry) {
            if (a.getName().equalsIgnoreCase(name3)) a.addCommands(skill);
        }
    }

    private void getQuantity() {
        if (this.registry.isEmpty()) System.out.println("В реестре животные ещё не регистрировались");
        else System.out.println("Всего в реестре было зарегистрировано животных: " + registry.get(0).getCounter());
    }

    private void printSortedRegistry() {
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
