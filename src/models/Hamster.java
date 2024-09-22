package models;

public class Hamster extends Pets{
    public Hamster(String name, String birthdate) {
        super(name, birthdate);
        super.type = "hamster";
    }
}
