package models;

public class Dog extends Pets{
    public Dog(String name, String birthdate) {
        super(name, birthdate);
        super.type = "dog";
    }
}
