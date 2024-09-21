package models;

import java.sql.Date;

public abstract class Animals {
    private int id = 0;
    private String name;
    private Type type;
    private Date birthdate;
    private String commands = "";

    public Animals(String name, Character type, String birthdate) {
        this.name = name;
        this.birthdate = Date.valueOf(birthdate);
        this.id++;
    }

    public void addCommands(String commands) {
        if (this.commands.isEmpty()) this.commands = commands;
        else this.commands = this.commands + ", " + commands;
    }

    public void dropAllCommands(){
        this.commands = "";
    }

    @Override
    public String toString() {
        return name + " " + type + " рожден: " + birthdate + " умеет выполнять команды: " + commands;
    }
}