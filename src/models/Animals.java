package models;

import java.sql.Date;

public class Animals {
    protected static int counter = 0;
    protected int id = 0;
    private String name;
    protected String type;
    private Date birthdate;
    private String commands = "";

    public Animals(String name, String birthdate) {
        this.name = capitalize(name);
        this.birthdate = Date.valueOf(birthdate);
        this.id = ++counter;
    }

    public void addCommands(String commands) {
        if (this.commands.isEmpty()) this.commands = commands;
        else this.commands = this.commands + ", " + commands;
    }

    public String getName() {
        return name;
    }

    public String getCommands() {
        return commands;
    }

    public int getCounter() {
        return counter;
    }

    public long getBirthdate() {
        return this.birthdate.getTime();
    }

    private String capitalize(String inputStr) {
        String[] mass = inputStr.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : mass) {
            char firstChar = word.charAt(0);
            char bigFirstChar = Character.toUpperCase(firstChar);
            result.append(bigFirstChar).append(word.substring(1).toLowerCase()).append(" ");
        }
        return result.toString().strip();
    }

    @Override
    public String toString() {
        return "{\"id\": \"" + id + "\", \"name\": \"" + name + "\", \"type\": \"" + type + "\", \"birthdate\": \""
                + birthdate + "\", \"commands\": \"" + commands + "\"}";
    }
}