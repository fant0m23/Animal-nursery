package models;

import java.sql.Date;

public class Animals {
    protected static int counter = 0;
    protected int id = 0;
    private String name;
    private Type type;
    private Date birthdate;
    private String commands = "";

    public Animals(String name, Character type, String birthdate) {
        this.name = name;
        this.birthdate = Date.valueOf(birthdate);
        this.id = ++counter;
    }

    public void addCommands(String commands) {
        if (this.commands.isEmpty()) this.commands = commands;
        else this.commands = this.commands + ", " + commands;
    }

    public void dropAllCommands() {
        this.commands = "";
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "id=" + id + "\tКличка: " + name + "\t(" + type + ")\tрожден: " + birthdate +
                "\tумеет выполнять команды: " + commands;
    }

    public long getBirthdate() {
        return this.birthdate.getTime();
    }
}