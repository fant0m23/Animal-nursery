package models;

public class Cat extends Pets{
    public Cat(String name, String birthdate) {
        super(name, birthdate);
        super.type = "cat";
    }
}
